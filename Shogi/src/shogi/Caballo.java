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
public class Caballo extends PiezaPromocionable {
    
    public Caballo(Jugador jugador) {
        super(jugador);
        this.nombre = "Caballo";
        this.nomenclatura = "N" + this.nomenclatura;
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
        
        /* el caballo avanza 2 filas y avanza o retrocede una columna, es decir, que la diferencia en 
        la columna debe ser +-1, y la diferencia en la fila debe ser 2 multiplicado por el sentido de ataque del jugador*/
        if(Math.abs(desde.getColumna() - hasta.getColumna()) != 1 || 
                hasta.getFila() - desde.getFila() != 2 * this.getJugador().getSentidoAtaque()) {
            return false;
        }
        
        return true;
    }

    @Override
    public boolean debePromover(Celda celda) {
        return ((this.jugador.getSentidoAtaque() == 1 && celda.getFila() >= 7) || 
                (this.jugador.getSentidoAtaque() == -1 && celda.getFila() <= 1) );
    }
    
    @Override
    public boolean puedeReingresar(Celda reingreso) {
        if(!super.puedeReingresar(reingreso)) {
            return false;
        }
        
        return !this.debePromover(reingreso);
    }
}
