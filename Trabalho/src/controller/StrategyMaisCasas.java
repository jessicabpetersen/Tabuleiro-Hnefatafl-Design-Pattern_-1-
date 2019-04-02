/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Campo;

/**
 *
 * @author Jéssica Petersen
 */
public class StrategyMaisCasas implements Strategy {

    @Override
    public boolean getMovimentoBranco(Campo[][] tabuleiro, int coluna, int linha, int colunaClicada, int linhaClicada) {
        if (moveuEmLinhaOuColuna(coluna, linha, colunaClicada, linhaClicada)) {
            if (moveuEmLinha(linha, linhaClicada)) { // moveu em linha - linha estatica- mudou de coluna
                if (coluna > colunaClicada) { // direita
                    if (!verificaColunaMovel(colunaClicada, coluna, false, linhaClicada, false, tabuleiro)) {
                        return true;
                    }
                } else { // esquerda
                    if (!verificaColunaMovel(coluna, colunaClicada, true, linhaClicada, false, tabuleiro)) {
                        return true;

                    }
                }
            } else { // moveu em coluna -- coluna estatica -mudou de linha
                if (linha > linhaClicada) {
                    //p baixo
                    if (!verificaLinhaMovel(linhaClicada, linha, false, colunaClicada, false, tabuleiro)) {
                        return true;
                    }

                } else {
                    // p cima
                    if (!verificaLinhaMovel(linha, linhaClicada, true, colunaClicada, false, tabuleiro)) {
                        return true;
                    }

                }
            }

        }
        return false;
    }

    @Override
    public boolean getMovimentoRei(Campo[][] tabuleiro, int coluna, int linha, int colunaClicada, int linhaClicada) {
        //verificar se moveu em linha ou em coluna e na casas corretas permitidas
        if (moveuEmLinhaOuColuna(coluna, linha, colunaClicada, linhaClicada)) {
            //moveu em linha ou coluna
            if (moveuEmLinha(linha, linhaClicada)) { //moveu em linha -- coluna estatica
                //verifica p ql lado
                if (coluna > colunaClicada) {
                    //verifica se tem peças entre as casas
                    if (!verificaColunaMovel(colunaClicada, coluna, false, linhaClicada, true, tabuleiro)) {
                        return true;
                    }
                } else {
                    if (!verificaColunaMovel(coluna, colunaClicada, true, linhaClicada, true, tabuleiro)) {
                        return true;

                    }
                }
            } else { //moveu em coluna -- linha estatica
                //verifica p ql lado andou
                if (linha > linhaClicada) {
                    //verifica se tem peças entre as casas
                    if (!verificaLinhaMovel(linhaClicada, linha, false, colunaClicada, true, tabuleiro)) {
                        return true;
                    }
                } else {
                    if (!verificaLinhaMovel(linha, linhaClicada, true, colunaClicada, true, tabuleiro)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    
    @Override
    public boolean getMovimentoPreto(Campo[][] tabuleiro, int coluna, int linha, int colunaAnterior, int linhaAnterior, Movimento movimento) {
        if (moveuEmLinhaOuColuna(coluna, linha, colunaAnterior, linhaAnterior)) {
            if (moveuEmLinha(linha, linhaAnterior)) { // linha igual - moveu em coluna
                if (coluna > colunaAnterior) {
                    if (!movimento.verificaLColunaMovel(colunaAnterior, coluna, false, linhaAnterior, colunaAnterior)) {
                        return true;
                    }
                } else {
                    if (!movimento.verificaLColunaMovel(coluna, colunaAnterior, true, linhaAnterior, colunaAnterior)) {
                        return true;
                    }
                }

            } else { //coluna estatica - mudou em linha
                if (linha > linhaAnterior) {
                    if (!movimento.verificaLinhaMovel(linhaAnterior, linha, false, colunaAnterior, linhaAnterior)) {
                        return true;
                    }
                } else {
                    if (!movimento.verificaLinhaMovel(linha, linhaAnterior, true, colunaAnterior, linhaAnterior)) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    /**
     * Verifica se moveu certo - em linha ou em coluna
     *
     * @param coluna - coluna clicada para o movimento
     * @param linha - linha clicada para o movimento
     * @param colunaClicada
     * @param linhaClicada
     * @return boolean - true:moveu certo, false:movimento em diagonal
     */
    public boolean moveuEmLinhaOuColuna(int coluna, int linha, int colunaClicada, int linhaClicada) {
        if (linha == linhaClicada || coluna == colunaClicada) {
            return true;
        }

        return false;
    }

    /**
     * Verifica se moveu em linha
     *
     * @param linha
     * @return boolean
     */
    public boolean moveuEmLinha(int linha, int linhaClicada) {
        if (linha == linhaClicada) {
            return true;
        }
        return false;
    }

    /**
     * Verifica se possui alguma peça entre tais casas na coluna movel -- linha
     * estatica
     *
     * @param menor
     * @param maior
     * @param pEsquerda - clicou em uma casa para mover à esquerda da clicada
     * @param linhaClicada
     * @param rei - a carta clicada é rei
     * @return boolean - true: achou uma casa no meio do movimento
     */
    public boolean verificaColunaMovel(int menor, int maior, boolean pEsquerda, int linhaClicada, boolean rei, Campo[][] tabuleiro) {
        boolean achou = false;
        if (pEsquerda) {
            for (int i = menor; i < maior; i++) {
                if (rei) {
                    if (tabuleiro[i][linhaClicada].verificaBranc() || tabuleiro[i][linhaClicada].verificarPret()) {
                        achou = true;
                        break;
                    }
                } else {
                    if (!tabuleiro[i][linhaClicada].verificaCampoNormal()) {
                        achou = true;
                        break;
                    }
                }
            }
        } else {
            for (int i = menor + 1; i <= maior; i++) {
                if (rei) {
                    if (tabuleiro[i][linhaClicada].verificaBranc() || tabuleiro[i][linhaClicada].verificarPret()) {
                        achou = true;
                        break;
                    }
                } else {
                    if (!tabuleiro[i][linhaClicada].verificaCampoNormal()) {
                        achou = true;
                        break;
                    }
                }
            }
        }
        return achou;
    }

    /**
     * Verifica se possui alguma peça entre tais casas na linha movel -- coluna
     * estatica
     *
     * @param menor
     * @param maior
     * @param pCima - clicou em uma casa para mover à cima da clicada
     * @param colunaClicada
     * @param rei
     * @return boolean
     */
    public boolean verificaLinhaMovel(int menor, int maior, boolean pCima, int colunaClicada, boolean rei, Campo[][] tabuleiro) {
        boolean achou = false;
        if (pCima) {
            for (int i = menor; i < maior; i++) {
                if (rei) {
                    if (tabuleiro[colunaClicada][i].verificaBranc() || tabuleiro[colunaClicada][i].verificarPret()) {
                        achou = true;
                        break;
                    }
                } else {
                    if (!tabuleiro[colunaClicada][i].verificaCampoNormal()) {
                        achou = true;
                        break;
                    }
                }
            }
        } else {
            for (int i = menor + 1; i <= maior; i++) {
                if (rei) {
                    if (tabuleiro[colunaClicada][i].verificaBranc() || tabuleiro[colunaClicada][i].verificarPret()) {
                        achou = true;
                        break;
                    }
                } else {
                    if (!tabuleiro[colunaClicada][i].verificaCampoNormal()) {
                        achou = true;
                        break;
                    }
                }
            }
        }
        return achou;
    }

}
