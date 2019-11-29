/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shogi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static shogi.MovimientoCaballoTest.caballo;
import static shogi.ParametrosPredefinidos.jugador1;

/**
 *
 * @author 54261
 */
public class CapturarPiezaTest {
    static Jugador jugador1 = new Jugador("blancas", 1);
    static Jugador jugador2 = new Jugador("negras", -1);
    static Caballo caballo = new Caballo(ParametrosPredefinidos.jugador1);
    static Celda celda = new Celda(2, 1);
    static Torre torreRival = new Torre(ParametrosPredefinidos.jugador2);
    
    public CapturarPiezaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        celda.setPieza(torreRival);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCapturarPieza() {
        System.out.println("testCapturarPieza");
        caballo.capturarPieza(celda);
        boolean expResult = true;
        for(Captura c : ParametrosPredefinidos.listaCapturasJugador1) {
            System.out.println(c.getPieza().nombre);
        }
        boolean result = ParametrosPredefinidos.listaCapturasJugador1.contains(torreRival);
        assertEquals(expResult, result);
    }
}
