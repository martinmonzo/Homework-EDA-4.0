/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shogi;

/**
 *
 * @author 54261
 */
public class Turno {
    private static int nroTurno = 1;
    private static Jugador jugador;

    public static int getNroTurno() {
        return nroTurno;
    }

    public static void setNroTurno(int nroTurno) {
        Turno.nroTurno = nroTurno;
    }

    public static Jugador getJugador() {
        return jugador;
    }

    public static void setJugador(Jugador jugador) {
        Turno.jugador = jugador;
    }
    
    
}
