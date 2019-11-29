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
public class GeneralPlata extends PiezaPromocionable {
    
    public GeneralPlata(Jugador jugador) {
        super(jugador);
        this.nombre = "GeneralPlata";
        this.nomenclatura = "S" + this.nomenclatura;
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
        
        /* el general de plata avanza o retrocede 1 fila. Si avanzó, puede avanzar o retroceder 1 columna
        o quedarse en la misma 
        (diferencia en fila = sentido de ataque => valor absoluto de diferencia en columna <= 1)
        
        Si retrocedió, no puede conservar la columna
        (diferencia en fila = -1 * sentido de ataque => valor absoluto de diferencia en columna = 1)
        */
        if(Math.abs(desde.getFila() - hasta.getFila()) != 1) { //la fila debe variar en 1
            return false;
        }
        
        if(hasta.getFila() - desde.getFila() == this.getJugador().getSentidoAtaque()) { //avanza, puede quedarse en la misma columna
            if(Math.abs(desde.getColumna() - hasta.getColumna()) > 1) {
                return false;
            }
        } else { //retrocede, debe cambiar de columna
            if(Math.abs(desde.getColumna() - hasta.getColumna()) != 1) {
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
