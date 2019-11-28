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
    
    
}
