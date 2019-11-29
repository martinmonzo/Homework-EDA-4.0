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

/**
 *
 * @author 54261
 */
public class MovimientoCaballoTest {
    static Jugador jugador = new Jugador("blancas", 1);
    static Caballo caballo = new Caballo(jugador);
    static Celda celda = new Celda(2, 1);
    
    public MovimientoCaballoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        celda.setPieza(caballo);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testPuedeMoverse() {
        System.out.println("testPuedeMoverse");
        boolean expResult = false;
        boolean result = caballo.puedeMoverse(celda, new Celda(6, 2), false);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
