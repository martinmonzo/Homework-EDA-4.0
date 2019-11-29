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
public class Partida {
    public static Scanner entrada = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        Turno.setJugador(ParametrosPredefinidos.jugador1); //comienza la partida
        String error = "";
        
        renderizarTablero();
        
        while(true) {
            System.out.println("\u001B[31m" + error + "\033[0m");
            error = "";
            Object desde = solicitarCeldaDesde();
            Celda hasta = ingresarMovimientoHasta();
            Pieza pieza = (desde instanceof Celda) ? ((Celda) desde).getPieza() : (Pieza) desde;
            
            if(desde instanceof Celda) { //mueve pieza
                if(pieza != null && pieza.puedeMoverse((Celda) desde, hasta, true)) {
                    pieza.moverse((Celda) desde, hasta);
                } else {
                    error = "Movimiento inválido. ";
                    continue;
                }
            }
            
            if(desde instanceof Pieza) { //reingresa pieza
                if(pieza != null && pieza.puedeReingresar(hasta)) {
                    pieza.reingresar(hasta);
                } else {
                    error = "Reingreso inválido. ";
                    continue;
                }
            }
            
            Turno.incrementarTurno();
            renderizarTablero();
        }
    }
    
    
    
    
    public static void renderizarTablero() {
        for(int col = 0; col < ParametrosPredefinidos.tablero.getInstancia().length; col++) {
            System.out.print("\t" + col);
        }
        System.out.println("\n\t-----------------------------------------------------------------");

        for(int i = 0; i < ParametrosPredefinidos.tablero.getInstancia().length; i++) {
            System.out.print(i + "|");
            for(int j = 0; j < ParametrosPredefinidos.tablero.getInstancia()[i].length; j++) {
                System.out.print("\t");
                if(ParametrosPredefinidos.tablero.getInstancia()[i][j].getPieza() != null) {
                    System.out.print(ParametrosPredefinidos.tablero.getInstancia()[i][j].getPieza().getNomenclatura());
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("|\n\n");
        }
        System.out.println("\t-----------------------------------------------------------------");
        
        ArrayList<Captura> listaCapturas = (Turno.getJugador() == ParametrosPredefinidos.jugador1) ?
                ParametrosPredefinidos.listaCapturasJugador1 : ParametrosPredefinidos.listaCapturasJugador2;
        
        System.out.println("Capturadas");
        for(int i = 0; i < listaCapturas.size(); i++) {
            System.out.print(i + "\t");
        }
        System.out.print("\n");
        for(int i = 0; i < listaCapturas.size(); i++) {
            System.out.print(listaCapturas.get(i).getPieza().getNomenclatura() + "\t");
        }
        
        System.out.println("\n\n Turno #" + Turno.getNroTurno() + " " + Turno.getJugador().getColorPiezas());
    }
    
    public static Object solicitarCeldaDesde() {
        int fila, columna;
        System.out.print("Desde (fila columna): ");
        String input = entrada.nextLine();
        
        if("QUIT".equals(input.toUpperCase())) {
            Turno.getJugador().rendirse();
        }
        
        String[] coordenadas = input.split(" ");
        
        try {
            fila = Integer.parseInt(coordenadas[0]);
            columna = Integer.parseInt(coordenadas[1]);
            if(fila == 9) { //fila = 9 para reingreso de pieza
                ArrayList<Captura> listaCapturas = (Turno.getJugador() == ParametrosPredefinidos.jugador1) ? 
                        ParametrosPredefinidos.listaCapturasJugador1 : ParametrosPredefinidos.listaCapturasJugador2;

                Pieza pieza = null;
                if(listaCapturas.size() > 0) {
                    pieza = listaCapturas.get(columna).getPieza();
                }
                if(pieza == null) {
                    throw new MyException("La pieza que desea reingresar no existe.");
                }
                return pieza;
            } else {
                if(coordenadas.length != 2) {
                    throw new MyException("Ingrese sólo 2 numeros.");
                }
                
                if(fila < 0 || fila > 8 || columna < 0 || columna > 8) {
                    throw new MyException("El valor de las celdas debe estar entre 0 y 8.");
                }
                
                Celda celda = ParametrosPredefinidos.tablero.getInstancia()[fila][columna];
                if(celda.getPieza() == null) {
                    throw new MyException("La celda se encuentra vacía");
                } else if(celda.getPieza().getJugador() != Turno.getJugador()) {
                    throw new MyException("La pieza que desea mover pertenece al rival.");
                }
            }

            return ParametrosPredefinidos.tablero.getInstancia()[fila][columna];
        } 
        
        catch(MyException e) {
            System.out.println("\u001B[31m" + e.getMessage() + "\033[0m");
            return solicitarCeldaDesde();
        }
        catch(Exception e) {
            System.out.println("\u001B[31m" + "Valor incorrecto" + "\033[0m");
            return solicitarCeldaDesde();
        }
    }
    
    public static Celda ingresarMovimientoHasta() {
        int fila, columna;
        while(true) {
            System.out.print("Hasta (fila columna): ");
            String celda = entrada.nextLine();
            
            if("QUIT".equals(celda.toUpperCase())) {
                Turno.getJugador().rendirse();
            }
            
            String[] coordenadas = celda.split(" ");
            try {
                fila = Integer.parseInt(coordenadas[0]);
                columna = Integer.parseInt(coordenadas[1]);
                
                if(coordenadas.length != 2) {
                    throw new MyException("Ingrese sólo 2 numeros.");
                }
                
                if(fila < 0 || fila > 8 || columna < 0 || columna > 8) {
                    throw new MyException("El valor de las celdas debe estar entre 0 y 8.");
                }

                break;            
            }
            catch(MyException e) {
                System.out.println("\u001B[31m" + e.getMessage() + "\033[0m");
                return ingresarMovimientoHasta();
            }
            catch(Exception e) {
                System.out.println("\u001B[31m" + "Valor incorrecto" + "\033[0m");
                return ingresarMovimientoHasta();
            }
        }
        return ParametrosPredefinidos.tablero.getInstancia()[fila][columna];
    }
}
