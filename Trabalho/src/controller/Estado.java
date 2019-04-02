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
public abstract class Estado {
    
    protected ControllerTela jogo;
    
    public Estado(ControllerTela jogo){
        this.jogo = jogo;
    }
    
    abstract void proximoEstado();
    
    abstract boolean isBranco();
    
    abstract boolean isEndGame();
    
}
