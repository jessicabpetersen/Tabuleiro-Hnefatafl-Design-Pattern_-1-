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
public abstract class DecoratorPecas implements Decorator{
    protected Decorator peca;
    
    public DecoratorPecas(Decorator peca){
        this.peca = peca;
    }

    @Override
    public Icon getImagem() {
       return this.peca.getImagem();
    }

    @Override
    public void setImagem(Icon imagem) {
        this.peca.setImagem(imagem);
    }
}
