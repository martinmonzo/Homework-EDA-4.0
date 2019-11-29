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
    public boolean debePromover(Celda celda) {
        return false;
    }
    
    
}
