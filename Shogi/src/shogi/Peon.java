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
    
       
}
