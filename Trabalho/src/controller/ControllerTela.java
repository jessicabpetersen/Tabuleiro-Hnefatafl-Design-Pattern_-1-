/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import model.BrancoClicado;
import model.Campo;
import model.CampoNormal;
import model.ComDecoracaoAnoNovo;
import model.ComDecoracaoNatal;
import model.Log;
import model.SemDecoracao;
import model.Decorator;
import model.ReiClicado;
import model.ReiRefugio;
import model.ReiRefugioClicado;

/**
 *
 * @author Jéssica Petersen
 */
public class ControllerTela implements Observado {

    private List<Observador> observadores = new ArrayList<>();
    private Campo[][] tabuleiro;
    private Campo[][] refugio;
    private int tamanho;
    private int reiMove;
    private int pecaMove;
    private int colunaClicada;
    private int linhaClicada;
    private boolean mover;
    private Tabuleiro distribuir;
    private Movimento movimento;
    private Log log;
    private Invoker ink;
    private JogadorProxy jogador;
    private static ControllerTela instance;
    Director director;
    Decorator imagem;
    private int decorou;
    private Estado estadoJogo;
    private boolean rodadaJogador;

    public ControllerTela(){
        estadoJogo = new EstadoBranco(this);
    }
    public boolean isRodadaJogador() {
        return rodadaJogador;
    }
    
     public void setEstadoJogo(Estado estadoJogo) {
        this.estadoJogo = estadoJogo;
    }
     

    public void setRodadaJogador(boolean rodadaJogador) {
        this.rodadaJogador = rodadaJogador;
    }

    

    public JogadorProxy getJogador() {
        return jogador;
    }

    public synchronized static ControllerTela getInstance() {
        if (instance == null) {
            instance = new ControllerTela();
        }
        return instance;
    }

    @Override
    public void addObservador(Observador obs) {
        observadores.add(obs);
    }

    public void getFactory() {
        Factory fac = null;
        switch (tamanho) {
            case 11:
                fac = new FactoryHnefatafl();
                break;
            case 7:
                fac = new FactoryBrandubh();
                break;
            case 9:
                fac = new FactoryTablut();
                break;
        }
        Strategy rei = null;
        switch (reiMove) {
            case 1:
                rei = new StrategyUmaCasa();
                break;
            case 2:
                rei = new StrategyMaisCasas();
                break;
            case 4:
                rei = new StrategyQuatroCasas();
                break;
        }

        Strategy peca = null;
        switch (pecaMove) {
            case 1:
                peca = new StrategyUmaCasa();
                break;
            case 2:
                peca = new StrategyMaisCasas();
                break;
        }
        this.distribuir = fac.createTabuleiro(rei, peca);
        this.movimento = fac.createMovimento();
        director = new Director(distribuir);
        director.construir();
        this.tabuleiro = this.distribuir.getTabuleiro();
        this.refugio = this.distribuir.getRefugio();
    }

    @Override
    public void inicializar() {
        jogador = new JogadorProxy();
        decorou = 0;
        log = new Log();
        ink = new Invoker();
        linhaClicada = -1;
        colunaClicada = -1;
        this.tabuleiro = new Campo[tamanho][tamanho];
        this.refugio = new Campo[tamanho][tamanho];
        getFactory();
        decorar();
        setRodadaJogador(true);
    }

    @Override
    public void distribuiPecas() {
        tabuleiro = distribuir.distribuiPecas();
        movimento.setTabuleiros(tabuleiro, refugio);
        notificarMudancaTabuleiro();
        
    }

    private void notificarMudancaTabuleiro() {
        for (Observador obs : observadores) {
            obs.mudouTabuleiro();
        }
    }

    private void notificarLabelJogador(String frase) {
        for (Observador obs : observadores) {
            obs.mudouJogador(frase);
        }
    }

    @Override
    public Icon getPeca(int col, int row) {
        return (this.tabuleiro[col][row] == null ? null : this.tabuleiro[col][row].getImagem());
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    @Override
    public void onMouseClicado(int linha, int coluna) {
        if (!this.estadoJogo.isEndGame()) {
            // verificar qual jogador é
            if (this.estadoJogo.isBranco()) { //BRANCO
                //verificar se qual açao: 
                //1 - selecionar (linha -1)
                //2 - deselecionar (linha tem gente e é igual a anterior)
                //3 - mover ( linha tem gente e é diferente da anterior)
                if (linhaClicada == -1) { // selecionar                
                    ///verifica se foi clinado no branco
                    if (this.tabuleiro[coluna][linha].clicado(this, linha, coluna)) {
                        Decorator clicado;
                        if(this.tabuleiro[coluna][linha].verificaBranc()){
                            clicado = new BrancoClicado(this.tabuleiro[coluna][linha]);
                        }else{
                            if(this.refugio[coluna][linha].verificarX()){
                                clicado = new ReiRefugioClicado(this.tabuleiro[coluna][linha]);
                            }else{
                                clicado = new ReiClicado(this.tabuleiro[coluna][linha]);
                            }
                        }
                            this.tabuleiro[coluna][linha].setImagem(clicado.getImagem());
                        this.linhaClicada = linha;
                        this.colunaClicada = coluna;
                    }
                } else {
                    // deselecionar ou mover
                    if (linha == linhaClicada && coluna == colunaClicada) {// deselecionar
                        if(this.tabuleiro[coluna][linha].verificarRei()){
                            if(this.refugio[coluna][linha].verificarX()){
                                ReiRefugio reiRefugio = new ReiRefugio(this.tabuleiro[coluna][linha]);
                                this.tabuleiro[coluna][linha].setImagem(reiRefugio.getImagem());
                            }else{
                                this.tabuleiro[coluna][linha].resetImagem();
                            }
                        }else{
                            this.tabuleiro[coluna][linha].resetImagem();
                        }
                        resetClique();
                    } else { // mover
                        //verificar se é rei ou peça normal
                        if (this.tabuleiro[colunaClicada][linhaClicada].verificarRei()) { //rei
                            if (this.distribuir.getStrategyRei(this.tabuleiro, coluna, linha, colunaClicada, linhaClicada)) {
                                this.tabuleiro = movimento.moverBranco(coluna, linha, linhaClicada, colunaClicada, true);
                                mover = true;
                                addLog(linha, coluna, "Defensor - Rei");
                                verificarVenceuRei(coluna, linha);
                                if (!this.estadoJogo.isEndGame()) {
                                    verificarProximaRodada(linha, coluna);
                                    verificaCaptura(linha, coluna, true);
                                    resetClique();
                                }
                            }
                        } else {//peça normal
                            if (this.distribuir.getStrategyBranco(this.tabuleiro, coluna, linha, colunaClicada, linhaClicada)) {
                                this.tabuleiro = movimento.moverBranco(coluna, linha, linhaClicada, colunaClicada, false);
                                mover = true;
                                addLog(linha, coluna, "Defensor");
                                verificaCaptura(linha, coluna, true);
                                resetClique();
                            }
                        }
                    }
                }
            } else { // PRETO
                //verificar se qual açao: 
                //1 - selecionar (linha -1)
                //2 - deselecionar (linha tem gente e é igual a anterior)
                //3 - mover ( linha tem gente e é diferente da anterior)

                if (linhaClicada == -1) { // selecionar
                    //verificar se foi clicado no preto
                    if (this.tabuleiro[coluna][linha].verificarPret()) {
                        this.tabuleiro = this.movimento.selecionarPreto(coluna, linha);
                        linhaClicada = linha;
                        colunaClicada = coluna;
                    }
                } else {
                    if (linha == linhaClicada && coluna == colunaClicada) { // deselecionar
                        if (this.tabuleiro[coluna][linha].verificarPret()) {
                            this.tabuleiro = this.movimento.deselecionarPreto(coluna, linha);
                            resetClique();
                        }
                    } else {//mover
                        if (this.distribuir.getStrategyPreto(this.tabuleiro, coluna, linha, colunaClicada, linhaClicada, this.movimento)) {
                            this.tabuleiro = this.movimento.moverPreto(coluna, linha, colunaClicada, linhaClicada);
                            mover = true;
                            addLog(linha, coluna, "Mercenario");
                            verificaCaptura(linha, coluna, false);
                            resetClique();
                            
                        }
                    }

                }

            }
            if (mover && !this.estadoJogo.isEndGame()) {
                this.estadoJogo.proximoEstado();
                if (this.estadoJogo.isBranco()) {
                    notificarLabelJogador("É a vez dos Defensores");
                } else {
                    notificarLabelJogador("É a vez dos Mercenários");
                }
                mover = false;
                this.distribuir.setTabuleiro(this.tabuleiro);
            }
            notificarMudancaTabuleiro();
        }
    }

    public void verificaCaptura(int linha, int coluna, boolean branca) {
        //verifica se tem um rei ou peca(branco ou preta) aos lados
        //verifica qual q moveu
        if (branca) {
            //verificar se tem alguma peça preta aos lados
            if (linha > 1) {
                if (this.tabuleiro[coluna][(linha - 1)].verificarPret()) { //verifica se tem acima
                    if (this.tabuleiro[coluna][(linha - 2)].verificarRei() || this.tabuleiro[coluna][(linha - 2)].verificaBranc() || this.tabuleiro[coluna][(linha - 2)].verificarX()) {
                        this.tabuleiro[coluna][(linha - 1)] = new CampoNormal();
                    }
                }
            }
            if (linha < (this.tabuleiro.length - 2)) {
                if (this.tabuleiro[coluna][(linha + 1)].verificarPret()) { //verifica se tem abaixo
                    if (this.tabuleiro[coluna][(linha + 2)].verificarRei() || this.tabuleiro[coluna][(linha + 2)].verificaBranc() || this.tabuleiro[coluna][(linha + 2)].verificarX()) {
                        this.tabuleiro[coluna][(linha + 1)] = new CampoNormal();
                    }
                }
            }

            if (coluna > 1) {
                if (this.tabuleiro[(coluna - 1)][linha].verificarPret()) { // verifica se tem a esquerda
                    if (this.tabuleiro[(coluna - 2)][linha].verificarRei() || this.tabuleiro[(coluna - 2)][linha].verificaBranc() || this.tabuleiro[(coluna - 2)][linha].verificarX()) {
                        this.tabuleiro[(coluna - 1)][linha] = new CampoNormal();
                    }
                }
            }
            if (coluna < (this.tabuleiro.length - 2)) {
                if (this.tabuleiro[(coluna + 1)][linha].verificarPret()) { // verifica se tem a direita
                    if (this.tabuleiro[(coluna + 2)][linha].verificarRei() || this.tabuleiro[(coluna + 2)][linha].verificaBranc() || this.tabuleiro[(coluna + 2)][linha].verificarX()) {
                        this.tabuleiro[(coluna + 1)][linha] = new CampoNormal();
                    }
                }
            }
        } else { //PRETO
            //verifica se tem branco/rei para capturar
            int qntdRei = 0;
            if (linha > 1) {
                if (this.tabuleiro[coluna][(linha - 1)].verificaBranc()) {
                    if (this.tabuleiro[coluna][(linha - 2)].verificarPret() || this.tabuleiro[coluna][(linha - 2)].verificarX()) {
                        this.tabuleiro[coluna][(linha - 1)] = new CampoNormal();
                    }

                }
            }
            if (linha > 0) {
                if (this.tabuleiro[coluna][(linha - 1)].verificarRei()) {
                    if (linha == 1) {
                        if (this.tabuleiro[(coluna - 1)][(linha - 1)].verificarPret() || this.tabuleiro[(coluna - 1)][(linha - 1)].verificarX()) {
                            qntdRei++;
                        }
                        if (this.tabuleiro[(coluna + 1)][(linha - 1)].verificarPret() || this.tabuleiro[(coluna + 1)][(linha - 1)].verificarX()) {
                            qntdRei++;

                        }
                        if (qntdRei == 1) {
                            olhaRei();
                        } else {
                            if (qntdRei == 2) {
                                this.tabuleiro[coluna][(linha - 1)] = new CampoNormal();
                                venceuPreto();
                            }
                        }
                    } else {
                        if (coluna == 0) {
                            qntdRei++;
                        } else {
                            if (this.tabuleiro[(coluna - 1)][(linha - 1)].verificarPret() || this.tabuleiro[(coluna - 1)][(linha - 1)].verificarX()) {
                                qntdRei++;
                            }
                        }
                        if (coluna == this.tabuleiro.length-1) {
                            qntdRei++;
                        } else {
                            if (this.tabuleiro[(coluna + 1)][(linha - 1)].verificarPret() || this.tabuleiro[(coluna + 1)][(linha - 1)].verificarX()) {
                                qntdRei++;
                            }
                        }
                        if (this.tabuleiro[coluna][(linha - 2)].verificarPret() || this.tabuleiro[coluna][(linha - 2)].verificarX()) {
                            qntdRei++;
                        }
                        if (qntdRei == 2) {
                            olhaRei();
                        } else {
                            if (qntdRei == 3) {
                                this.tabuleiro[coluna][(linha - 1)] = new CampoNormal();
                                venceuPreto();
                            }
                        }
                    }
                }

            }
            if (linha < (this.tabuleiro.length - 2)) {
                if (this.tabuleiro[(coluna)][(linha + 1)].verificaBranc()) {
                    if (this.tabuleiro[coluna][(linha + 2)].verificarPret() || this.tabuleiro[coluna][(linha + 2)].verificarX()) {
                        this.tabuleiro[coluna][(linha + 1)] = new CampoNormal();
                    }
                }
            }
            if (linha < (this.tabuleiro.length - 1)) {
                if (this.tabuleiro[(coluna)][(linha + 1)].verificarRei()) {
                    if (linha == (this.tabuleiro.length - 2)) {
                        if (this.tabuleiro[(coluna - 1)][(linha + 1)].verificarPret() || this.tabuleiro[(coluna - 1)][(linha + 1)].verificarX()) {
                            qntdRei++;
                        }
                        if (this.tabuleiro[(coluna + 1)][(linha + 1)].verificarPret() || this.tabuleiro[(coluna + 1)][(linha + 1)].verificarX()) {
                            qntdRei++;
                        }
                        if (qntdRei == 1) {
                            olhaRei();
                        } else {
                            if (qntdRei == 2) {
                                this.tabuleiro[coluna][(linha + 1)] = new CampoNormal();
                                venceuPreto();
                            }
                        }
                    } else {
                        if (coluna == 0) {
                            qntdRei++;
                        } else {
                            if (this.tabuleiro[(coluna - 1)][(linha + 1)].verificarPret() || this.tabuleiro[(coluna - 1)][(linha + 1)].verificarX()) {
                                qntdRei++;
                            }
                        }
                        if (this.tabuleiro.length-1 == coluna) {
                            qntdRei++;
                        } else {
                            if (this.tabuleiro[(coluna + 1)][(linha + 1)].verificarPret() || this.tabuleiro[(coluna + 1)][(linha + 1)].verificarX()) {
                                qntdRei++;
                            }
                        }
                        if (this.tabuleiro[coluna][(linha + 2)].verificarPret() || this.tabuleiro[coluna][(linha + 2)].verificarX()) {
                            qntdRei++;
                        }
                        if (qntdRei == 2) {
                            olhaRei();
                        } else {
                            if (qntdRei == 3) {
                                this.tabuleiro[coluna][(linha + 1)] = new CampoNormal();
                                venceuPreto();
                            }
                        }
                    }
                }

            }
            if (coluna > 1) {
                if (this.tabuleiro[(coluna - 1)][linha].verificaBranc()) {
                    if (this.tabuleiro[(coluna - 2)][linha].verificarPret() || this.tabuleiro[(coluna - 2)][linha].verificarX()) {
                        this.tabuleiro[(coluna - 1)][linha] = new CampoNormal();
                    }
                }
            }
            if (coluna > 0) {
                if (this.tabuleiro[(coluna - 1)][linha].verificarRei()) {
                    if (coluna == 1) {
                        if (this.tabuleiro[(coluna - 1)][(linha - 1)].verificarX() || this.tabuleiro[(coluna - 1)][(linha - 1)].verificarPret()) {
                            qntdRei++;
                        }
                        if (this.tabuleiro[(coluna - 1)][(linha + 1)].verificarX() || this.tabuleiro[(coluna - 1)][(linha + 1)].verificarPret()) {
                            qntdRei++;
                        }
                        if (qntdRei == 1) {
                            olhaRei();
                        } else {
                            if (qntdRei == 2) {
                                this.tabuleiro[(coluna - 1)][linha] = new CampoNormal();
                                venceuPreto();
                            }
                        }
                    } else {
                        if (linha == 0) {
                            qntdRei++;
                        } else {
                            if (this.tabuleiro[(coluna - 1)][(linha - 1)].verificarX() || this.tabuleiro[(coluna - 1)][(linha - 1)].verificarPret()) {
                                qntdRei++;
                            }
                        }
                        if (linha == this.tabuleiro.length-1) {
                            qntdRei++;
                        } else {
                            if (this.tabuleiro[(coluna - 1)][(linha + 1)].verificarX() || this.tabuleiro[(coluna - 1)][(linha + 1)].verificarPret()) {
                                qntdRei++;
                            }
                        }
                        if (this.tabuleiro[(coluna - 2)][linha].verificarPret() || this.tabuleiro[(coluna - 2)][linha].verificarX()) {
                            qntdRei++;
                        }
                        if (qntdRei == 2) {
                            olhaRei();
                        } else {
                            if (qntdRei == 3) {
                                this.tabuleiro[(coluna - 1)][linha] = new CampoNormal();
                                venceuPreto();
                            }
                        }
                    }
                }
            }
            if (coluna < (this.tabuleiro.length - 2)) {
                if (this.tabuleiro[(coluna + 1)][linha].verificaBranc()) {
                    if (this.tabuleiro[(coluna + 2)][linha].verificarPret() || this.tabuleiro[(coluna + 2)][linha].verificarX()) {
                        this.tabuleiro[(coluna + 1)][linha] = new CampoNormal();
                    }
                }
            }
            if (coluna < (this.tabuleiro.length - 1)) {
                if (this.tabuleiro[(coluna + 1)][linha].verificarRei()) {
                    if (coluna == (this.tabuleiro.length - 2)) {
                        if (this.tabuleiro[(coluna + 1)][linha - 1].verificarPret() || this.tabuleiro[(coluna + 1)][linha - 1].verificarX()) {
                            qntdRei++;
                        }
                        if (this.tabuleiro[(coluna + 1)][linha + 1].verificarPret() || this.tabuleiro[(coluna + 1)][linha + 1].verificarX()) {
                            qntdRei++;
                        }
                        if (qntdRei == 1) {
                            olhaRei();
                        } else {
                            if (qntdRei == 2) {
                                this.tabuleiro[(coluna + 1)][linha] = new CampoNormal();
                                venceuPreto();
                            }
                        }
                    } else {
                        if (linha == 0) {
                            qntdRei++;
                        } else {
                            if (this.tabuleiro[(coluna + 1)][linha - 1].verificarPret() || this.tabuleiro[(coluna + 1)][linha - 1].verificarX()) {
                                qntdRei++;
                            }
                        }
                        if (linha == this.tabuleiro.length-1) {
                            qntdRei++;
                        } else {
                            if (this.tabuleiro[(coluna + 1)][linha + 1].verificarPret() || this.tabuleiro[(coluna + 1)][linha + 1].verificarX()) {
                                qntdRei++;
                            }
                        }
                        if (this.tabuleiro[(coluna + 2)][linha].verificarPret() || this.tabuleiro[(coluna + 2)][linha].verificarX()) {
                            qntdRei++;
                        }
                        if (qntdRei == 2) {
                            olhaRei();
                        } else {
                            if (qntdRei == 3) {
                                this.tabuleiro[(coluna + 1)][linha] = new CampoNormal();
                                venceuPreto();
                            }
                        }
                    }
                }
            }
        }

    }

    public void addLog(int linha, int coluna, String jogador) {
        int ColunaAnterior = colunaClicada + 1;
        int LinhaAnterior = linhaClicada + 1;
        ink.add(new AddCommand(log, jogador, "coluna: " + ColunaAnterior + " linha: " + LinhaAnterior, "coluna: " + (coluna + 1) + " linha: " + (linha + 1)));
        ink.execute();
    }

    @Override
    public void novoJogo() {
        this.tabuleiro = null;
        inicializar();
        distribuiPecas();
        notificarMudancaTabuleiro();
        notificarLabelJogador("É a vez dos Defensores");
        mover = false;
        if(!isRodadaJogador() || !this.estadoJogo.isBranco()){
            this.estadoJogo.proximoEstado();
        }
    }

    @Override
    public void escolhaJogo(int tabuleiro, int movimentoNormal, int movimentoRei) {
        this.pecaMove = movimentoNormal;
        this.reiMove = movimentoRei;
        switch (tabuleiro) {
            case 1:
                tamanho = 11;
                break;
            case 2:
                tamanho = 7;
                break;
            case 3:
                tamanho = 9;
                break;
        }
        for (Observador obs : observadores) {
            obs.tamanhoTabela(tamanho);
        }
        inicializar();
    }

    /**
     * Verificar se naquela posição era refugo
     *
     * @param row
     * @param col
     * @return
     */
    public boolean verificarRefugio(int row, int col) {
        if (this.refugio[col][row].verificarX()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Resetar as linhas clicadas
     */
    public void resetClique() {
        this.linhaClicada = -1;
        this.colunaClicada = -1;
        
    }

    @Override
    public String logMovimento() {
        return ink.imprimir();
    }

    public void verificarProximaRodada(int linha, int coluna) {
        if (reiMove == 2) {
            if (verificarRaichi(linha, coluna) && !this.refugio[coluna][linha].verificaRefugio()) {
                for (Observador observador : observadores) {
                    observador.falarTela("Raichi!");
                }
            }
        }

    }

    public boolean verificarRaichi(int linha, int coluna) {
        boolean verificacao[][] = verificacao(linha, coluna);
        for (int i = 0; i < 4; i++) {
            if (verificacao[i][0] == true && verificacao[i][1] == false) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarRaichiDuplo(int linha, int coluna) {
        boolean verificacao[][] = verificacao(linha, coluna);
        if (((verificacao[0][0] == true && verificacao[0][1] == false) && (verificacao[1][0] == true && verificacao[1][1] == false))
                || (verificacao[2][0] == true && verificacao[2][1] == false) && verificacao[3][0] == true && verificacao[3][1] == false) {
            return true;
        }

        return false;
    }

    public boolean[][] verificacao(int linha, int coluna) {
        boolean verificacao[][] = {{false, false}, {false, false}, {false, false}, {false, false}};
        for (int i = 0; i < this.tabuleiro.length; i++) {
            //linha
            if (i < linha) {// linhas acima
                if (this.tabuleiro[coluna][i].verificaRefugio()) {
                    verificacao[0][0] = true;
                }
                if (!this.tabuleiro[coluna][i].verificaCampoNormal() && !this.tabuleiro[coluna][i].verificaRefugio()) {
                    verificacao[0][1] = true;
                }
            } else {
                if (i > linha) { // linha abaixo
                    if (this.tabuleiro[coluna][i].verificaRefugio()) {
                        verificacao[1][0] = true;
                    }
                    if (!this.tabuleiro[coluna][i].verificaCampoNormal() && !this.tabuleiro[coluna][i].verificaRefugio()) {
                        verificacao[1][1] = true;
                    }
                }
            }
            //coluna
            if (i < coluna) { //coluna esquerda
                if (this.tabuleiro[i][linha].verificaRefugio()) {
                    verificacao[2][0] = true;
                }
                if (!this.tabuleiro[i][linha].verificaCampoNormal() && !this.tabuleiro[i][linha].verificaRefugio()) {
                    verificacao[2][1] = true;
                }
            } else { // coluna direita
                if (i > coluna) {
                    if (this.tabuleiro[i][linha].verificaRefugio()) {
                        verificacao[3][0] = true;
                    }
                    if (!this.tabuleiro[i][linha].verificaCampoNormal() && !this.tabuleiro[i][linha].verificaRefugio()) {
                        verificacao[3][1] = true;
                    }
                }
            }
        }
        return verificacao;
    }

    @Override
    public String numPecas() {
        VisitorPecas visitor = new VisitorPecas();
        this.distribuir.accept(visitor);
        return visitor.getNumPecas();
    }

    @Override
    public String estatisticaRei() {
        VisitorRei visitor = new VisitorRei();
        this.distribuir.accept(visitor);
        VisitorRefugio visitorR = new VisitorRefugio(visitor);
        this.distribuir.accept(visitorR);
        return visitorR.getEstatistica();
    }

    @Override
    public Icon decorar() {
        switch (decorou) {
            case 0:
                decorou++;
                imagem = new SemDecoracao(new ImageIcon("img/semDecoracao.png"));
                return imagem.getImagem();
            case 1:
                decorou++;
                Decorator decoracaoNatal = new ComDecoracaoNatal(imagem);
               // decoracaoNatal.setImagem(new ImageIcon("img/comDecoracao.png"));
                return decoracaoNatal.getImagem();
            case 2:
                decorou++;
                Decorator decoracaoAnoNovo = new ComDecoracaoAnoNovo(imagem);
                //decoracaoAnoNovo.setImagem(new ImageIcon("img/comDecoracao1.png"));
                return decoracaoAnoNovo.getImagem();
            default:
                decorou = 1;
                imagem = new SemDecoracao(new ImageIcon("img/semDecoracao.png"));
                break;
        }
        return imagem.getImagem();
    }

    public void verificarVenceuRei(int coluna, int linha) {
        if (verificarRaichiDuplo(linha, coluna)) {
            for (Observador obs : observadores) {
                obs.falarTela("Tuichi!");
                obs.desabilitarBotoes();
            }
        } else {
            if (this.refugio[coluna][linha].verificaRefugio()) {
                setRodadaJogador(false);
                this.estadoJogo.proximoEstado();
                for (Observador obs : observadores) {
                    obs.falarTela("Defensor Venceu");
                    obs.desabilitarBotoes();
                }
            }
        }
    }

    public void venceuPreto() {
        setRodadaJogador(false);
        this.estadoJogo.proximoEstado();
        for (Observador obs : observadores) {
            obs.falarTela("Mercenário Venceu");
            obs.desabilitarBotoes();
        }
    }
    
    public void olhaRei() {
        for (Observador obs : observadores) {
            obs.falarTela("Olha o Rei");
        }
    }

}
