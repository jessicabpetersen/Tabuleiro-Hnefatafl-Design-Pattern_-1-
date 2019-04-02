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
public class VisitorPecas implements Visitor {
    
    public int pecasBrancas = 0;
    public int pecasPretas = 0;

    @Override
    public void visit(Campo campo, int coluna, int linha) {
        if( campo.verificaBranc() || campo.verificarRei()){
            pecasBrancas++;
        }else{
            if(campo.verificarPret()){
                pecasPretas++;
            }
        }
    }
    
    public String getNumPecas(){
        return " Defensores possuem "+ pecasBrancas+" peças\n Mercenários possuem "+ pecasPretas+" peças";
    }
    
}
