/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Campo;

/**
 *
 * @author Jéssica Petersen
 */
public class VisitorRefugio implements Visitor{
    
    private VisitorRei rei;
    private int coluna;
    private int linha ;
    private int casas = 999;
    
    public VisitorRefugio(VisitorRei rei){
        this.rei = rei;
    }
    
    
    @Override
    public void visit(Campo campo, int coluna, int linha) {
        if(campo.verificaRefugio()){
            int casaColuna =  Math.abs(rei.getColuna() - coluna);
            int casaLinha = Math.abs(rei.getLinha() - linha);
            if((casaColuna+ casaLinha) < casas){
                this.coluna = coluna;
                this.linha = linha;
                this.casas = (casaColuna + casaLinha);
            }
        }
    }
    
    public String getEstatistica(){
        return "O Refúgio mais perto está na linha "+ (linha+1)+" e coluna "+(coluna+1)+ " há "+casas+" casa(s) de distância do rei.";
    }
    
}
