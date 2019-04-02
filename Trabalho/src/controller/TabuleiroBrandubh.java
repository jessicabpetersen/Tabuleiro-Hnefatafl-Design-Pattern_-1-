/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.ImageIcon;
import model.Branco;
import model.Campo;
import model.CampoNormal;
import model.Preto;
import model.Refugio;
import model.Rei;
import model.Trono;
import model.Decorator;

/**
 *
 * @author Jéssica Petersen
 */
public class TabuleiroBrandubh extends Tabuleiro {

    private Campo[][] tabuleiro;
    private Campo[][] refugio;

    public TabuleiroBrandubh(Strategy strategyrei, Strategy strategyrpeca) {
        super(strategyrei, strategyrpeca);
    }

    @Override
    public void distribuirCampos() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if ((i == j && (i == 0 || i == tabuleiro.length - 1)) || (i == 0 && j == tabuleiro.length - 1) || (j == 0 && i == tabuleiro.length - 1)) {
                    this.tabuleiro[i][j] = new Refugio();
                    this.refugio[i][j] = new Refugio();
                } else {
                    if (i == j && i == tabuleiro.length / 2) {
                        Decorator trono = new Trono();
                        this.tabuleiro[i][j] = (Campo) trono;
                        this.refugio[i][j] = new Trono();
                    } else {
                        this.tabuleiro[i][j] = new CampoNormal();
                        this.refugio[i][j] = new CampoNormal();
                    }
                }
            }
        }
    }

    @Override
    public Campo[][] distribuiPecas() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if ((j == 3 && (i == 0 || i == 1 || i == 5 || i == 6)) || (i == 3 && (j == 0 || j == 1 || j == 5 || j == 6))) {
                    this.tabuleiro[i][j] = new Preto();
                } else {
                    if (j == 3 && i == 3) {
                        this.tabuleiro[i][j] = new Rei();
                        this.tabuleiro[i][j].setImagem(new ImageIcon("img/reibrancoregufio.png"));
                    } else {
                        if ((i == 3 && (j == 2 || j == 4)) || (j == 3 && (i == 2 || i == 4))) {
                            this.tabuleiro[i][j] = new Branco();
                        }
                    }
                }
            }
        }
        return this.tabuleiro;
    }

    @Override
    public Campo[][] getRefugio() {
        return refugio;
    }

    @Override
    public Campo[][] getTabuleiro() {
        return this.tabuleiro;
    }

    @Override
    public void reset() {
        this.tabuleiro = new Campo[7][7];
        this.refugio = new Campo[7][7];
    }

    @Override
    public void accept(Visitor visitor) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                visitor.visit(this.tabuleiro[i][j], i, j);

            }
        }

    }

    @Override
    public void setTabuleiro(Campo[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

}
