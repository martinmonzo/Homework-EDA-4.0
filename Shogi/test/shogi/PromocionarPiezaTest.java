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
public class PromocionarPiezaTest {
    Jugador jugador = new Jugador("negras", -1);
    Peon pieza = new Peon(jugador);
    Celda celda = new Celda(2, 0);
    
    
    public PromocionarPiezaTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        celda.setPieza(pieza);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testPromover() {
        System.out.println("testPromover");
        pieza.promover();
        boolean expResult = true;
        boolean result = pieza.isPromocionada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
