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
public class Trono extends Campo implements Decorator{

    public Trono() {
        super(new ImageIcon("img/refugio.png"));
    }

    @Override
    public boolean clicado(ControllerTela controller, int linha, int coluna) {
        return false;
    }

    @Override
    public boolean isBrancoDeselecionar() {
        return false;
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
        return true;
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

}
