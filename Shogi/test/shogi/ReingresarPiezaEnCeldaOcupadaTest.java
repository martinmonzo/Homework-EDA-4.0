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
public class ReingresarPiezaEnCeldaOcupadaTest {
    static Jugador jugador = new Jugador("negras", -1);
    static Peon pieza = new Peon(jugador);
    static Celda celda = new Celda(4, 5);
    
    public ReingresarPiezaEnCeldaOcupadaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        celda.setPieza(new Caballo(jugador));
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
    public void testPuedeReingresar() {
        System.out.println("testPuedeReingresar");
        boolean expResult = false;
        boolean result = pieza.puedeReingresar(celda);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
