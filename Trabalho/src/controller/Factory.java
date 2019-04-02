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
public abstract class Factory {
    
    public abstract Tabuleiro createTabuleiro(Strategy strategyRei, Strategy strategyPeca);
    
    public abstract Movimento createMovimento();
    
}
