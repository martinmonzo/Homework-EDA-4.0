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
    
    public boolean puedeDarJaqueMate() {
        Jugador rival = (ParametrosPredefinidos.jugador1 == this) ?
                ParametrosPredefinidos.jugador2 : ParametrosPredefinidos.jugador1;
                
        for(int i = 0; i < ParametrosPredefinidos.tablero.getCantidadFilas(); i++) {
            for(int j = 0; j < ParametrosPredefinidos.tablero.getCantidadColumnas(); j++) {
                Celda celda = ParametrosPredefinidos.tablero.getInstancia()[i][j];
                if(celda.getPieza() != null && celda.getPieza().getJugador() == rival) {
                    if(celda.getPieza().puedeMoverseAAlgunaCelda(celda)) {
                        return false;
                    }
                }
            }
        }
        
        ArrayList<Captura> listaCapturas = (this == ParametrosPredefinidos.jugador1) ? 
                ParametrosPredefinidos.listaCapturasJugador2 : ParametrosPredefinidos.listaCapturasJugador1;
        
        for(Captura captura : listaCapturas) {
            Pieza pieza = captura.getPieza();
            if(pieza.puedeReingresarAAlgunaCelda()) {
                return false;
            }
        }
        
        return true;
    }
    
    public void darJaqueMate() {
        System.out.println(this.getColorPiezas() + " GANA POR JAQUE MATE.");
        System.exit(0);
    }
}
