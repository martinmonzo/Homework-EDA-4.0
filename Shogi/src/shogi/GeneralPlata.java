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
    
    
}
