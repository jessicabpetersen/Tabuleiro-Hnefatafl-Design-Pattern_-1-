/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.ImageIcon;
import model.Campo;
import model.CampoNormal;
import model.Preto;
import model.PretoClicado;

/**
 *
 * @author Jéssica Petersen
 */
public class MovimentoOutros extends Movimento {

    private static MovimentoOutros instance;

    public synchronized static MovimentoOutros getInstance() {
        if (instance == null) {
            instance = new MovimentoOutros();
        }
        return instance;
    }

    @Override
    public Campo[][] selecionarPreto(int coluna, int linha) {
        PretoClicado preto = new PretoClicado(tabuleiro[coluna][linha]);
        this.tabuleiro[coluna][linha].setImagem(preto.getImagem());
        return this.tabuleiro;
    }

    @Override
    public Campo[][] deselecionarPreto(int coluna, int linha) {
        this.tabuleiro[coluna][linha].resetImagem();
        return this.tabuleiro;
    }


    @Override
    public Campo[][] moverPreto(int coluna, int linha, int colunaAnterior, int linhaAnterior) {
        this.tabuleiro[coluna][linha] = new Preto();
        this.tabuleiro[colunaAnterior][linhaAnterior] = new CampoNormal();
        return this.tabuleiro;
    }

    @Override
    public boolean verificaLinhaMovel(int menor, int maior, boolean pCima, int colunaClicada, int linhaClicada) {
        boolean achou = false;
        if (pCima) {
            for (int i = menor; i < maior; i++) {
                if (!this.tabuleiro[colunaClicada][i].verificaCampoNormal()) {
                    achou = true;
                    break;
                }
            }
        } else {
            for (int i = menor + 1; i <= maior; i++) {
                if (!this.tabuleiro[colunaClicada][i].verificaCampoNormal()) {
                    achou = true;
                    break;
                }
            }
        }
        return achou;
    }
    
//colunaClicada, coluna, false, linhaClicada, ColunaClicada
    @Override
    public boolean verificaLColunaMovel(int menor, int maior, boolean pEsquerda, int linhaClicada, int colunaClicada) {
        boolean achou = false;
        if (pEsquerda) {
            for (int i = menor; i < maior; i++) {
                if (!this.tabuleiro[i][linhaClicada].verificaCampoNormal()) {
                    achou = true;
                    break;
                }
            }
        } else {
            for (int i = menor + 1; i <= maior; i++) {
                if (!this.tabuleiro[i][linhaClicada].verificaCampoNormal()) {
                    achou = true;
                    break;
                }
            }
        }
        return achou;
    }

}
