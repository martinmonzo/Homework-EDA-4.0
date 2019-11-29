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
public class GeneralOro extends PiezaNoPromocionable {
    
    public GeneralOro(Jugador jugador) {
        super(jugador);
        this.nombre = "GeneralOro";
        this.nomenclatura = "G" + this.nomenclatura;
    }
    
    /**
     *
     * @param desde
     * @param hasta
     * @param checkearJaque
     * @return
     */
    @Override
    public boolean puedeMoverse(Celda desde, Celda hasta, boolean checkearJaque) {
        if(!super.puedeMoverse(desde, hasta, checkearJaque)) return false;
        
        /* el general de oro puede avanzar o retroceder 1 fila, o quedarse en la misma fila.
        ( valor absoluto de diferencia de fila <= 1)
        Puede avanzar o retroceder una columna, siempre que no retroceda filas
        (si valor absoluto de diferencia de fila = 0 o sentido ataque => valor absoluto de diferencia de columna = 1)
        (sino => diferencia de columna = 0) */
        
        if(Math.abs(desde.getFila() - hasta.getFila()) > 1) { //la fila debe variar en 0 o 1
            return false;
        }
        
        if(Math.abs(desde.getColumna() - hasta.getColumna()) > 1) { //la columna debe variar en 0 o 1
            return false;
        }
        
        if(desde.getFila() == hasta.getFila() || hasta.getFila() - desde.getFila() == this.getJugador().getSentidoAtaque()) {
            //avanza o conserva la fila, puede moverse 1 columna
            if(Math.abs(desde.getColumna() - hasta.getColumna()) > 1) {
                return false;
            }
        } else { //retrocede
            if(desde.getColumna() != hasta.getColumna()) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     *
     * @param pieza
     * @param desde
     * @param hasta
     * @return
     */
    public static boolean puedeMoverse(Pieza pieza, Celda desde, Celda hasta) {
        if(Math.abs(desde.getFila() - hasta.getFila()) > 1) { //la fila debe variar en 0 o 1
            return false;
        }
        
        if(Math.abs(desde.getColumna() - hasta.getColumna()) > 1) { //la columna debe variar en 0 o 1
            return false;
        }
        
        if(desde.getFila() == hasta.getFila() || hasta.getFila() - desde.getFila() == pieza.getJugador().getSentidoAtaque()) {
            //avanza o conserva la fila, puede moverse 1 columna
            if(Math.abs(desde.getColumna() - hasta.getColumna()) > 1) {
                return false;
            }
        } else { //retrocede
            if(desde.getColumna() != hasta.getColumna()) {
                return false;
            }
        }
        
        return true;
    }
    
}
