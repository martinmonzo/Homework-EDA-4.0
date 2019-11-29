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
    
    /**
     *
     * @param reingreso
     * @return
     */
    @Override
    public boolean puedeReingresar(Celda reingreso) {
        if(!super.puedeReingresar(reingreso)) {
            return false;
        }
        
        if(this.debePromover(reingreso)) {
            return false;
        }
        
        for (Celda[] instancia : ParametrosPredefinidos.tablero.getInstancia()) {
            if (instancia[reingreso.getColumna()].getPieza() != null && instancia[reingreso.getColumna()].getPieza() instanceof Peon && instancia[reingreso.getColumna()].getPieza().getJugador() == this.getJugador()) {
                return false;
            }
        }
        
        reingreso.setPieza(this); //ubico la pieza para probar si podría dar jaque mate y es un peon

        for (Celda[] instancia : ParametrosPredefinidos.tablero.getInstancia()) {
            for (Celda instancia1 : instancia) {
                if (instancia1.getPieza() != null && instancia1.getPieza() instanceof Rey && instancia1.getPieza().getJugador() != this.getJugador()) {
                    if(this.jugador.puedeDarJaqueMate()) {
                        reingreso.setPieza(null);
                        return false;
                    }
                }
            }
        }

        /*if(this.puedeMoverse(reingreso, celdaReyRival)) { //es peón y podría dar jaque mate
            //CAMBIAR - JAQUE MATE EN VEZ DE JAQUE
            reingreso.setPieza(null);
            return false;
        }*/
        
        return true;
    }
}
