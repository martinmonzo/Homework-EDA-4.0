/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shogi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 54261
 */
public abstract class Pieza {
    protected String nombre;
    protected String nomenclatura;
    
    protected Jugador jugador;

    public Pieza(Jugador jugador) {
        this.nomenclatura = (jugador.getSentidoAtaque() == 1 ? "↓" : "↑");
        this.jugador = jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    public boolean puedeDarJaque(Celda desde) {
        if(desde.getPieza() == this) {
            Celda celdaReyRival = null;
        
            for (Celda[] instancia : ParametrosPredefinidos.tablero.getInstancia()) {
                for (Celda instancia1 : instancia) {
                    if (instancia1.getPieza() != null && instancia1.getPieza() instanceof Rey && instancia1.getPieza().getJugador() != this.getJugador()) {
                        celdaReyRival = instancia1;
                        break;
                    }
                }
            }
            
            return this.puedeMoverse(desde, celdaReyRival, false);
            /*if(this.puedeMoverse(desde, celdaReyRival)) {
                celdaReyRival.getPieza().getJugador().setEnJaque(true);
            };*/
        }
        
        return false;
    }

    public void darJaque(Jugador jugador) {
        jugador.setEnJaque(true);
        System.out.println("\033[0;35m" + "¡JAQUE!" + "\033[0m");
        
        if(this.getJugador().puedeDarJaqueMate()) {
            this.getJugador().darJaqueMate();
        }
    }
    
    public boolean puedeMoverse(Celda desde, Celda hasta, boolean checkearJaque) {
        //valido si se sale de los limites del tablero
        if(hasta.getFila() < 0 || hasta.getColumna() < 0 || hasta.getFila() > ParametrosPredefinidos.tablero.getCantidadFilas() || hasta.getColumna() > ParametrosPredefinidos.tablero.getCantidadColumnas()) {
            return false;
        }
        
        //valido si hay una pieza distinta en la celda desde, o si la celda está vacía
        if(desde.getPieza() != this) {
            return false;
        }
        
        //valido si se mueve a una celda ocupada
        if(hasta.getPieza() != null) {
            if(hasta.getPieza().getJugador() == this.getJugador()) { //no puede moverse a donde ya tiene una pieza propia
                return false;
            }
        }
        
        //valido si quedo en jaque
        if(checkearJaque) {
            Pieza piezaHasta = hasta.getPieza();
            Pieza piezaDesde = desde.getPieza();
            hasta.setPieza(this);
            desde.setPieza(null);
            
            for (int i = 0; i < ParametrosPredefinidos.tablero.getCantidadFilas(); i++) {
                for (int j = 0; j < ParametrosPredefinidos.tablero.getCantidadColumnas(); j++) {
                    Celda celda = ParametrosPredefinidos.tablero.getInstancia()[i][j];
                    if (celda.getPieza() != null && celda.getPieza().getJugador() != this.getJugador()) {
                        if(celda.getPieza().puedeDarJaque(celda)) {
                            hasta.setPieza(piezaHasta);
                            desde.setPieza(piezaDesde);
                            return false;
                        }
                    }
                }
            }
            
            hasta.setPieza(piezaHasta);
            desde.setPieza(piezaDesde);
        }
        //se mueve a una celda vacía
        return true;
    }

    public boolean puedeMoverseAAlgunaCelda(Celda desde) {
        for (Celda[] instancia : ParametrosPredefinidos.tablero.getInstancia()) {
            for (Celda celda : instancia) {
                if(this.puedeMoverse(desde, celda, true)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public void moverse(Celda desde, Celda hasta) {
        desde.setPieza(null);
        
        if(hasta.getPieza() != null) { //si hay pieza en el destino, la come
            capturarPieza(hasta);
        }
        
        if(this instanceof PiezaPromocionable) {
            PiezaPromocionable _this = (PiezaPromocionable) this;
            if(_this.debePromover(hasta)) {
                _this.promover();
            } else if(_this.puedePromover(hasta)) {
                Scanner entrada = new Scanner(System.in);
                System.out.print("¿Desea promover la pieza? (s/n): ");
                String respuesta = entrada.nextLine();

                if("S".equals(respuesta.toUpperCase())) {
                    _this.promover();
                }
            }
        }
        
        
        hasta.setPieza(this);
        if(this.puedeDarJaque(hasta)) {
            Jugador rival = (this.jugador == ParametrosPredefinidos.jugador1) ?
                    ParametrosPredefinidos.jugador2 : ParametrosPredefinidos.jugador1;
            this.darJaque(rival);
        }
    }
    
    public boolean puedeReingresar(Celda reingreso) {
        /* - Si la celda reingreso está ocupada, no puede
         *   - Si la celda esta vacía, y la pieza no es un peón, puede
         *   - Si está vacía y es un peón:
         *        - Si hay otro peón en la misma columna, no puede
         *        - Si puede moverse a donde está el rey rival, no puede
         */
        if(reingreso.getPieza() != null) {
            return false;
        }
        
        reingreso.setPieza(this);
            
        for (int i = 0; i < ParametrosPredefinidos.tablero.getCantidadFilas(); i++) {
            for (int j = 0; j < ParametrosPredefinidos.tablero.getCantidadColumnas(); j++) {
                Celda celda = ParametrosPredefinidos.tablero.getInstancia()[i][j];
                if (celda.getPieza() != null && celda.getPieza().getJugador() != this.getJugador()) {
                    if(celda.getPieza().puedeDarJaque(celda)) {
                        reingreso.setPieza(null);
                        return false;
                    }
                }
            }
        }

        reingreso.setPieza(null);
        return true;
    }
    
    public boolean puedeReingresarAAlgunaCelda() {
        for (Celda[] instancia : ParametrosPredefinidos.tablero.getInstancia()) {
            for (Celda celda : instancia) {
                if(this.puedeReingresar(celda)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public void reingresar(Celda reingreso) {
        reingreso.setPieza(this);
        
        ArrayList<Captura> listaCapturas = (this.getJugador() == ParametrosPredefinidos.jugador1) ?
                ParametrosPredefinidos.listaCapturasJugador1 : ParametrosPredefinidos.listaCapturasJugador2;
        
        if(listaCapturas.size() > 0) {
            for(int i = 0; i < listaCapturas.size(); i++) {
                if(listaCapturas.get(i).getPieza() == this) {
                    listaCapturas.remove(i);
                }
            }
        }
        
        if(this.puedeDarJaque(reingreso)) {
            Jugador rival = (this.jugador == ParametrosPredefinidos.jugador1) ?
                    ParametrosPredefinidos.jugador2 : ParametrosPredefinidos.jugador1;
            this.darJaque(rival);
        }
    }
    
    public void capturarPieza(Celda hasta) {
        Pieza pieza = hasta.getPieza();
        pieza.setJugador(this.getJugador());
        
        if(pieza instanceof PiezaPromocionable) {
            PiezaPromocionable _pieza = (PiezaPromocionable) pieza;
            _pieza.quitarPromocion();
        }
        
        if(pieza.nomenclatura.contains("↓")) {
            pieza.setNomenclatura(pieza.nomenclatura.replace("↓", "↑"));
        } else {
            pieza.setNomenclatura(pieza.nomenclatura.replace("↑", "↓"));
        }
        
        ArrayList<Captura> listaCapturas = (this.getJugador() == ParametrosPredefinidos.jugador1) ?
                ParametrosPredefinidos.listaCapturasJugador1 : ParametrosPredefinidos.listaCapturasJugador2;
        
        listaCapturas.add(new Captura(pieza, this.getJugador()));
        hasta.setPieza(this);
    }
}
