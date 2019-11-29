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
public class Torre extends PiezaPromocionable {
    
    public Torre(Jugador jugador) {
        super(jugador);
        this.nombre = "Torre";
        this.nomenclatura = "R" + this.nomenclatura;
    }
    
    @Override
    public boolean puedeMoverse(Celda desde, Celda hasta, boolean checkearJaque) {
        if(!super.puedeMoverse(desde, hasta, checkearJaque)) return false;
        
        if(this.promocionada) { //movimiento de la torre promocionada
            if(this.puedeMoversePromocionado(desde, hasta)) {
                return true;
            }
        }
        /* la torre mueve en línea recta, es decir, que la diferencia en alguna de las 2
        direcciones (fila o columna) debe ser 0*/
        if(desde.getFila() != hasta.getFila() && desde.getColumna() != hasta.getColumna()) {
            return false;
        }
        
        //verificar si hay alguna pieza en el medio del camino
        int sentidoFila = (desde.getFila() < hasta.getFila()) ? 1 : (desde.getFila() == hasta.getFila() ? 0 : -1);
        int sentidoColumna = (desde.getColumna() < hasta.getColumna()) ? 1 : (desde.getColumna() == hasta.getColumna() ? 0 : -1);
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

    @Override
    public boolean debePromover(Celda celda) {
        return false;
    }
    
    public boolean puedeMoversePromocionado(Celda desde, Celda hasta) {
        if(Math.abs(hasta.getFila() - desde.getFila()) != 1 || Math.abs(hasta.getColumna()- desde.getColumna()) != 1) {
            return false;
        }
        
        return true;
    }    
}
