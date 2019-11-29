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
public class Alfil extends PiezaPromocionable {
    
    public Alfil(Jugador jugador) {
        super(jugador);
        this.nombre = "Alfil";
        this.nomenclatura = "B" + this.nomenclatura;
    }
    
    @Override
    public boolean puedeMoverse(Celda desde, Celda hasta, boolean checkearJaque) {
        if(!super.puedeMoverse(desde, hasta, checkearJaque)) return false;
        
        if(this.promocionada) { //movimiento del alfil promocionado
            if(this.puedeMoversePromocionado(desde, hasta)) {
                return true;
            }
        }
        /* el alfil mueve en diagonal, es decir, que la diferencia entre las 
        * filas desde y hasta, debe ser igual a la diferencia entre las columnas 
        * desde y hasta, en valor absoluto */
        if(Math.abs(desde.getFila() - hasta.getFila()) != Math.abs(desde.getColumna() - hasta.getColumna())) {
            return false;
        }
        
        //verificar si hay alguna pieza en el medio del camino
        int sentidoFila = desde.getFila() < hasta.getFila() ? 1 : -1;
        int sentidoColumna = desde.getColumna() < hasta.getColumna() ? 1 : -1;
        int filaActual = desde.getFila() + sentidoFila;
        int columnaActual = desde.getColumna() + sentidoColumna;
        while(filaActual != hasta.getFila() || columnaActual != hasta.getColumna()) {
            if(ParametrosPredefinidos.tablero.getInstancia()[filaActual][columnaActual].getPieza() != null) {
                return false;
            }
            
            filaActual += sentidoFila;
            columnaActual += sentidoColumna;
        }
        
        return true;
    }
    
    public boolean puedeMoversePromocionado(Celda desde, Celda hasta) {
        if(desde.getFila() == hasta.getFila()) {
            if(Math.abs(hasta.getColumna() - desde.getColumna()) != 1) {
                return false;
            }
        }

        if(desde.getColumna() == hasta.getColumna()) {
            if(Math.abs(hasta.getFila() - desde.getFila()) != 1) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public boolean debePromover(Celda celda) {
        return false;
    }
    
    
}
