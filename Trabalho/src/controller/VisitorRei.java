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
public class VisitorRei implements Visitor{
    
    private int linha;
    private int coluna;

    @Override
    public void visit(Campo campo, int coluna, int linha) {
        if(campo.verificarRei()){
            this.linha = linha;
            this.coluna = coluna;
        }
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }    
}
