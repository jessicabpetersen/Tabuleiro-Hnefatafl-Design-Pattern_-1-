/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ControllerTela;
import javax.swing.ImageIcon;

/**
 *
 * @author Jéssica Petersen
 */
public class Branco extends Peca {

    public Branco() {
        super(new ImageIcon("img/branco.png"));
    }

    @Override
    public boolean clicado(ControllerTela controller, int linha, int coluna) {
        if (super.getJogador1(controller)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isBrancoDeselecionar() {
        setImagem(new ImageIcon("img/branco.png"));
        return true;
    }

    @Override
    public boolean verificarRei() {
        return false;
    }

    @Override
    public boolean verificarPret() {
        return false;
    }

    @Override
    public boolean verificarX() {
        return false;
    }

    @Override
    public boolean verificaRefugio() {
        return false;
    }

    @Override
    public boolean verificaBranc() {
        return true;
    }

    @Override
    public boolean verificaCampoNormal() {
        return false;
    }

    @Override
    public void resetImagem() {
         setImagem(new ImageIcon("img/branco.png"));
    }

}
