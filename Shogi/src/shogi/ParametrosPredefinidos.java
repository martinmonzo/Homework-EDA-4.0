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
public class ParametrosPredefinidos {
    //creo una lista con las capturas de ambos jugadores
    public static ArrayList<Captura> listaCapturasJugador1 = new ArrayList<Captura>();
    public static ArrayList<Captura> listaCapturasJugador2 = new ArrayList<Captura>();
    
    //creo los jugadores
    public static Jugador jugador1 = new Jugador("blancas", 1);
    public static Jugador jugador2 = new Jugador("negras", -1);
    
    //creo el tablero
    public static Tablero tablero = new Tablero();
}
