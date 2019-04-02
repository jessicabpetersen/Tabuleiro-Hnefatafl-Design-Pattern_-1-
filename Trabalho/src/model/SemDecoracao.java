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
public class SemDecoracao implements Decorator{
    
    public Icon imagem;
    
    public SemDecoracao(Icon Imagem){
        this.imagem = Imagem;
    }

    public Icon getImagem() {
        return imagem;
    }

    public void setImagem(Icon imagem) {
        this.imagem = imagem;
    }
    
    
}
