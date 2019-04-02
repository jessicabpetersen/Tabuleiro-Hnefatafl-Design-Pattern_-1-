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
public class EstadoGameOver  extends Estado {

    public EstadoGameOver(ControllerTela jogo) {
        super(jogo);
    }

    @Override
    void proximoEstado() {
        if(this.jogo.isRodadaJogador()){
            this.jogo.setEstadoJogo(new EstadoBranco(jogo));
        }
    }

    @Override
    boolean isBranco() {
        return false;
    }

    @Override
    boolean isEndGame() {
        return true;
    }
}
