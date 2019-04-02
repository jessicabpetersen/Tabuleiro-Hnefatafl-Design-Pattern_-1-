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
public class Director {
    
    private Tabuleiro tabuleiro;
    
    public Director(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
    }
    
    public void construir(){
        tabuleiro.reset();
        tabuleiro.distribuirCampos();
    }
}
