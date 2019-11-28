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
public abstract class PiezaPromocionable extends Pieza {
    protected boolean promocionada;

    public PiezaPromocionable(Jugador jugador) {
        super(jugador);
        this.promocionada = false;
    }

    public boolean isPromocionada() {
        return promocionada;
    }

    public void setPromocionada(boolean promocionada) {
        this.promocionada = promocionada;
    }
    
    public void promover() {
        this.promocionada = true;
        this.setNomenclatura("+" + this.nomenclatura);
    }
}
