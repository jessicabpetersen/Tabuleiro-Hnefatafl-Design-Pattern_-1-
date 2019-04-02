/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Campo;
import model.CampoNormal;
import model.Preto;
import model.PretoClicado;
import model.PretoRefugio;
import model.PretoRefugioClicado;
import model.Refugio;

/**
 *
 * @author Jéssica Petersen
 */
public class MovimentoTablut extends Movimento {

    private static MovimentoTablut instance;

    public synchronized static MovimentoTablut getInstance() {
        if (instance == null) {
            instance = new MovimentoTablut();
        }
        return instance;
    }

    @Override
    public Campo[][] selecionarPreto(int coluna, int linha) {
        if (this.refugio[coluna][linha].verificaRefugio()) {
            PretoRefugioClicado preto = new PretoRefugioClicado(this.tabuleiro[coluna][linha]);
            this.tabuleiro[coluna][linha].setImagem(preto.getImagem());
        } else {
            PretoClicado preto = new PretoClicado(this.tabuleiro[coluna][linha]);
            this.tabuleiro[coluna][linha].setImagem(preto.getImagem());
        }
        return this.tabuleiro;
    }

    @Override
    public Campo[][] deselecionarPreto(int coluna, int linha) {
        if (this.refugio[coluna][linha].verificaRefugio()) {
            PretoRefugio preto = new PretoRefugio(this.tabuleiro[coluna][linha]);
            this.tabuleiro[coluna][linha].setImagem(preto.getImagem());
        } else {
            this.tabuleiro[coluna][linha].resetImagem();
        }
        return this.tabuleiro;
    }

    @Override
    public boolean verificaLinhaMovel(int menor, int maior, boolean pCima, int colunaClicada, int linhaClicada) {
        boolean achou = false;
        if (pCima) {
            for (int i = menor; i < maior; i++) {
                if (!this.tabuleiro[colunaClicada][i].verificaCampoNormal() && !this.tabuleiro[colunaClicada][i].verificaRefugio()) {
                    achou = true;
                    break;
                }
            }
        } else {
            for (int i = menor + 1; i <= maior; i++) {
                if (!this.tabuleiro[colunaClicada][i].verificaCampoNormal() && !this.tabuleiro[colunaClicada][i].verificaRefugio()) {
                    achou = true;
                    break;
                }
            }
        }
        return achou;
    }

    @Override
    public boolean verificaLColunaMovel(int menor, int maior, boolean pEsquerda, int linhaClicada, int colunaClicada) {
        boolean achou = false;
        if (pEsquerda) {
            for (int i = menor; i < maior; i++) {
                if (!this.tabuleiro[i][linhaClicada].verificaCampoNormal() && !this.tabuleiro[i][linhaClicada].verificaRefugio()) {
                    achou = true;
                    break;
                }
            }
        } else {
            for (int i = menor + 1; i <= maior; i++) {
                if (!this.tabuleiro[i][linhaClicada].verificaCampoNormal() && !this.tabuleiro[i][linhaClicada].verificaRefugio()) {
                    achou = true;
                    break;
                }
            }
        }
        return achou;
    }

    @Override
    public Campo[][] moverPreto(int coluna, int linha, int colunaAnterior, int linhaAnterior) {
        //verificar se o anterior era refugio
        if (this.refugio[colunaAnterior][linhaAnterior].verificaRefugio()) {
            //verificar se o proximo será refugio
            this.tabuleiro[colunaAnterior][linhaAnterior] = new Refugio();
            this.tabuleiro[coluna][linha] = new Preto();
            if (this.refugio[coluna][linha].verificaRefugio()) {
                // era refugio e será refugio novamente
                PretoRefugio preto = new PretoRefugio(this.tabuleiro[coluna][linha]);
                this.tabuleiro[coluna][linha].setImagem(preto.getImagem());
            }

        } else {// nao era refugio anteriormente
            this.tabuleiro[colunaAnterior][linhaAnterior] = new CampoNormal();
            this.tabuleiro[coluna][linha] = new Preto();
            //verificar se o proximo será refugio
            if (this.refugio[coluna][linha].verificaRefugio()) {
                // nao era refugio e vai ser refugio
                PretoRefugio preto = new PretoRefugio(this.tabuleiro[coluna][linha]);
                this.tabuleiro[coluna][linha].setImagem(preto.getImagem());
            }
        }
        return this.tabuleiro;
    }

}
