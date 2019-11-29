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
public class Peon extends PiezaPromocionable {
    
    public Peon(Jugador jugador) {
        super(jugador);
        this.nombre = "Peon";
        this.nomenclatura = "P" + this.nomenclatura;
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
        //el peón no puede cambiar de columna
        //el peón puede moverse a una fila superior o inferior en 1, dependiendo el sentido de ataque del jugador
        
        return (desde.getColumna() == hasta.getColumna() && hasta.getFila() - desde.getFila() == this.getJugador().getSentidoAtaque());
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
