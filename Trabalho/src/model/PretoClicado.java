/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jéssica Petersen
 */
public class PretoClicado extends DecoratorPecas{
    
    public PretoClicado(Decorator peca) {
        super(peca);
    }
    @Override
    public Icon getImagem() {
        super.setImagem( new ImageIcon("img/pretoclicado.png"));
        return super.getImagem();
    }

}
