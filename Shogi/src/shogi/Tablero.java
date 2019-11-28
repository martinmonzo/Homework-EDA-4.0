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
