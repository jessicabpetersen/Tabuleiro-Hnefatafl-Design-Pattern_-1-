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
public class Rei extends Peca {

    public Rei() {
        super(new ImageIcon("img/reibranco.png"));
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
        return true;
    }

    @Override
    public boolean verificarRei() {
        return true;
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
        return false;
    }

    @Override
    public boolean verificaCampoNormal() {
        return false;
    }

    @Override
    public void resetImagem() {
        setImagem(new ImageIcon("img/reibranco.png"));
    }
}
