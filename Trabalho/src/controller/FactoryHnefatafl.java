/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.MovimentoOutros.getInstance;

/**
 *
 * @author Jéssica Petersen
 */
public class FactoryHnefatafl extends Factory{
    
    private Tabuleiro Hnefatafl;
    private Movimento movimento;
    
    @Override
    public Tabuleiro createTabuleiro(Strategy strategyRei, Strategy strategyPeca) {
        if(Hnefatafl == null){
            Hnefatafl = new TabuleiroHnefatafl(strategyRei, strategyPeca);
        }
        return Hnefatafl;
    }

    @Override
    public Movimento createMovimento() {
        if(movimento == null)
            movimento = getInstance();
        return movimento;
    }
    
}
