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
public interface Strategy {
    
    boolean getMovimentoRei(Campo[][] tabuleiro, int coluna, int linha, int colunaClicada, int linhaClicada);
    
    boolean getMovimentoBranco(Campo[][] tabuleiro, int coluna, int linha, int colunaClicada, int linhaClicada);
    
    boolean getMovimentoPreto(Campo[][] tabuleiro, int coluna, int linha, int colunaClicada, int linhaClicada, Movimento movimento);
}
