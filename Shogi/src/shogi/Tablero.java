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
public class Tablero {
    private final int cantidadFilas = 9;
    private final int cantidadColumnas = 9;
    private final int indiceMaximoPromocion = 6;
    private final int indiceMinimoPromocion = 2;
    
    private final Celda[][] instancia = new Celda[cantidadFilas][cantidadColumnas];

    public Tablero() {
        Jugador jugador1 = ParametrosPredefinidos.jugador1;
        Jugador jugador2 = ParametrosPredefinidos.jugador2;
        //creo todas las celdas vacías
        for(int i = 0; i < cantidadFilas; i++) {
            for(int j = 0; j < cantidadColumnas; j++) {
                instancia[i][j] = new Celda(i, j);
            }
        }
        
        //ubico los peones
        for(int j = 0; j < cantidadColumnas; j++) {
            Celda celda2j = instancia[2][j];
            celda2j.setPieza(new Peon(jugador1));
            
            Celda celda6j = instancia[6][j];
            celda6j.setPieza(new Peon(jugador2));
        }
        
        //ubico las torres
        Celda celda11 = instancia[1][1];
        celda11.setPieza(new Torre(jugador1));
        Celda celda77 = instancia[7][7];
        celda77.setPieza(new Torre(jugador2));
        
        //ubico los alfiles
        Celda celda17 = instancia[1][7];
        celda17.setPieza(new Alfil(jugador1));
        Celda celda71 = instancia[7][1];
        celda71.setPieza(new Alfil(jugador2));
        
        //ubico los lanceros
        Celda celda00 = instancia[0][0];
        celda00.setPieza(new Lancero(jugador1));
        Celda celda08 = instancia[0][8];
        celda08.setPieza(new Lancero(jugador1));
        Celda celda80 = instancia[8][0];
        celda80.setPieza(new Lancero(jugador2));
        Celda celda88 = instancia[8][8];
        celda88.setPieza(new Lancero(jugador2));
        
        //ubico los caballos
        Celda celda01 = instancia[0][1];
        celda01.setPieza(new Caballo(jugador1));
        Celda celda07 = instancia[0][7];
        celda07.setPieza(new Caballo(jugador1));
        Celda celda81 = instancia[8][1];
        celda81.setPieza(new Caballo(jugador2));
        Celda celda87 = instancia[8][7];
        celda87.setPieza(new Caballo(jugador2));
        
        //ubico los generales de plata
        Celda celda02 = instancia[0][2];
        celda02.setPieza(new GeneralPlata(jugador1));
        Celda celda06 = instancia[0][6];
        celda06.setPieza(new GeneralPlata(jugador1));
        Celda celda82 = instancia[8][2];
        celda82.setPieza(new GeneralPlata(jugador2));
        Celda celda86 = instancia[8][6];
        celda86.setPieza(new GeneralPlata(jugador2));
        
        //ubico los generales de oro
        Celda celda03 = instancia[0][3];
        celda03.setPieza(new GeneralOro(jugador1));
        Celda celda05 = instancia[0][5];
        celda05.setPieza(new GeneralOro(jugador1));
        Celda celda83 = instancia[8][3];
        celda83.setPieza(new GeneralOro(jugador2));
        Celda celda85 = instancia[8][5];
        celda85.setPieza(new GeneralOro(jugador2));
        
        //ubico los reyes
        Celda celda04 = instancia[0][4];
        celda04.setPieza(new Rey(jugador1));
        Celda celda84 = instancia[8][4];
        celda84.setPieza(new Rey(jugador2));
    }

    public int getCantidadFilas() {
        return cantidadFilas;
    }

    public int getCantidadColumnas() {
        return cantidadColumnas;
    }

    public Celda[][] getInstancia() {
        return instancia;
    }

    public int getIndiceMaximoPromocion() {
        return indiceMaximoPromocion;
    }

    public int getIndiceMinimoPromocion() {
        return indiceMinimoPromocion;
    }
}
