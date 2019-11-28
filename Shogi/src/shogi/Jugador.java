/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shogi;

import java.util.ArrayList;

/**
 *
 * @author 54261
 */
public class Jugador {
    private String colorPiezas;
    private int sentidoAtaque;
    private boolean enJaque = false;

    public Jugador(String colorPiezas, int sentidoAtaque) {
        this.colorPiezas = colorPiezas;
        this.sentidoAtaque = sentidoAtaque;
    }

    public String getColorPiezas() {
        return colorPiezas;
    }

    public void setColorPiezas(String colorPiezas) {
        this.colorPiezas = colorPiezas;
    }

    public int getSentidoAtaque() {
        return sentidoAtaque;
    }

    public void setSentidoAtaque(int sentidoAtaque) {
        this.sentidoAtaque = sentidoAtaque;
    }

    public boolean isEnJaque() {
        return enJaque;
    }

    public void setEnJaque(boolean enJaque) {
        this.enJaque = enJaque;
    }

    public void rendirse() {
        System.out.println(this.getColorPiezas() + " se ha rendido. FIN DE LA PARTIDA");
        System.exit(0);
    }
    
    public void darJaqueMate() {
        System.out.println(this.getColorPiezas() + " GANA POR JAQUE MATE.");
        System.exit(0);
    }
}
