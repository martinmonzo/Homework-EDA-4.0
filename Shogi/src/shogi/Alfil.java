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
    public boolean debePromover(Celda celda) {
        return false;
    }
    
    
}
