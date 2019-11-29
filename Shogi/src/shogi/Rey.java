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
public class Rey extends PiezaNoPromocionable {
    
    public Rey(Jugador jugador) {
        super(jugador);
        this.nombre = "Rey";
        this.nomenclatura = "K" + this.nomenclatura;
    }
    
    @Override
    public boolean puedeMoverse(Celda desde, Celda hasta, boolean checkearJaque) {
        if(!super.puedeMoverse(desde, hasta, checkearJaque)) return false;
        
        /* el rey mueve en cualquier sentido, 1 celda, es decir, que la diferencia
        tanto en fila como en columna debe ser menor o igual a 1*/
        if(Math.abs(desde.getFila() - hasta.getFila()) > 1 || Math.abs(desde.getColumna() - hasta.getColumna()) > 1) {
            return false;
        }
        
        return true;
    }
}
