/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Jéssica Petersen
 */
public interface Observador {
    
    void tamanhoTabela(int tamanho);
    
    void mudouTabuleiro();
    
    void mudouJogador(String frase);
    
    void falarTela(String frase);
    
    void desabilitarBotoes();
}
