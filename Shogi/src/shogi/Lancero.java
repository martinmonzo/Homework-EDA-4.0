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
public class Lancero extends PiezaPromocionable {
    
    public Lancero(Jugador jugador) {
        super(jugador);
        this.nombre = "Lancero";
        this.nomenclatura = "L" + this.nomenclatura;
    }
    
    /**
     *
     * @param desde
     * @param hasta
     * @return
     */
    @Override
    public boolean puedeMoverse(Celda desde, Celda hasta, boolean checkearJaque) {
        if(!super.puedeMoverse(desde, hasta, checkearJaque)) return false;
        
        if(this.promocionada) { //movimiento del general de oro
            return GeneralOro.puedeMoverse(this, desde, hasta);
        }
        
        /* el lancero mueve sólo hacia adelante, es decir, que la diferencia en
        columnas debe ser 0, y la diferencia de filas debe coincidir con el signo del sentido
        de ataque del jugador */
        if(desde.getColumna() != hasta.getColumna() || 
                hasta.getFila() - desde.getFila() != Math.abs(hasta.getFila() - desde.getFila()) * this.getJugador().getSentidoAtaque()) {
            return false;
        }
        
        //verificar si hay alguna pieza en el medio del camino
        int sentidoFila = this.getJugador().getSentidoAtaque();
        int filaActual = desde.getFila() + sentidoFila;
        while(filaActual != hasta.getFila()) {
            if(ParametrosPredefinidos.tablero.getInstancia()[filaActual][desde.getColumna()].getPieza() != null) {
                return false;
            }
            
            filaActual += sentidoFila;
        }
        
        return true;
    }

    /**
     *
     * @param celda
     * @return
     */
    @Override
    public boolean debePromover(Celda celda) {
        return ((this.jugador.getSentidoAtaque() == 1 && celda.getFila() == 8) || 
                (this.jugador.getSentidoAtaque() == -1 && celda.getFila() == 0) );
    }
    
    
}
