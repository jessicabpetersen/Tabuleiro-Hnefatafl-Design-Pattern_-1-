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
public abstract class Tabuleiro {

    private Strategy strategyRei;
    private Strategy strategyPeca;

    public Tabuleiro(Strategy strategyrei, Strategy strategyrpeca) {
        this.strategyRei = strategyrei;
        this.strategyPeca = strategyrpeca;
    }

    public boolean getStrategyRei(Campo[][] tabuleiro, int coluna, int linha, int colunaClicada, int linhaClicada) {
        return strategyRei.getMovimentoRei(tabuleiro, coluna, linha, colunaClicada, linhaClicada);
    }

    public boolean getStrategyBranco(Campo[][] tabuleiro, int coluna, int linha, int colunaClicada, int linhaClicada) {
        return strategyPeca.getMovimentoBranco(tabuleiro, coluna, linha, colunaClicada, linhaClicada);
    }

    public boolean getStrategyPreto(Campo[][] tabuleiro, int coluna, int linha, int colunaAnterior, int linhaAnterior, Movimento movimento) {
        return strategyPeca.getMovimentoPreto(tabuleiro, coluna, linha, colunaAnterior, linhaAnterior, movimento);
    }

    public abstract Campo[][] getTabuleiro();

    public abstract void reset();

    /**
     * Distribui os Campos na tela (CampoNormal ou Refugio) de acordo com o
     * tabuleiro Especifico para os 3
     *
     * @param normal
     * @param rei
     * @return tabuleiro
     */
    public abstract void distribuirCampos();

    /**
     * Distribui as peças (Branco - Preto - Rei) nas casas Especifico para os 3
     *
     * @return tabuleiro
     */
    public abstract Campo[][] distribuiPecas();

    public abstract Campo[][] getRefugio();
    
    public abstract void accept(Visitor visitor);
    
    public abstract void setTabuleiro(Campo[][] tabuleiro);
}
