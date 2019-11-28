/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shogi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 54261
 */
public abstract class Pieza {
    protected String nombre;
    protected String nomenclatura;
    
    protected Jugador jugador;

    public Pieza(Jugador jugador) {
        this.nomenclatura = (jugador.getSentidoAtaque() == 1 ? "↓" : "↑");
        this.jugador = jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    
}
