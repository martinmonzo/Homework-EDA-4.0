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
     * @param celda
     * @return
     */
    @Override
    public boolean debePromover(Celda celda) {
        return ((this.jugador.getSentidoAtaque() == 1 && celda.getFila() == 8) || 
                (this.jugador.getSentidoAtaque() == -1 && celda.getFila() == 0) );
    }
    
    
}
