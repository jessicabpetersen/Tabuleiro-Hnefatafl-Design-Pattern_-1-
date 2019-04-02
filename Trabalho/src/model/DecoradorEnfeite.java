/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.Icon;

/**
 *
 * @author Jéssica Petersen
 */
public abstract class DecoradorEnfeite implements Decorator{
    
    private Decorator natal;
    
    public DecoradorEnfeite(Decorator natal){
        this.natal = natal;
    }

    @Override
    public Icon getImagem() {
        return this.natal.getImagem();
    }

    @Override
    public void setImagem(Icon imagem) {
        this.natal.setImagem(imagem);
    }
    
}
