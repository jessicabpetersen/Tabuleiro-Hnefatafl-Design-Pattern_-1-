/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ControllerTela;
import javax.swing.Icon;

/**
 *
 * @author Jéssica Petersen
 */
public abstract class Campo implements Decorator{

    private Icon imagem;

    public Campo(Icon imagem) {
        this.imagem = imagem;
    }

    public void setImagem(Icon imagem) {
        this.imagem = imagem;
    }

    public Icon getImagem() {
        return imagem;
    }
    
    public boolean getJogador1(ControllerTela controller){
        if(controller.getJogador().verificarJogador1()){
          return true;   
        }
        return false;
    }
    public void resetImagem(){
        setImagem(imagem);
    }

    public abstract boolean clicado(ControllerTela controller, int linha, int coluna);
    
    public abstract boolean isBrancoDeselecionar();
    
    public abstract boolean verificarRei();
    
    public abstract boolean verificarPret();
    
    public abstract boolean verificaBranc();
    
    public abstract boolean verificarX();
    
    public abstract boolean verificaRefugio();
    
    public abstract boolean verificaCampoNormal();
    
    
}
