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
public class PeonTest {
    
    public PeonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    /**
     * Test of puedeMoverse method, of class Peon.
     */
    @Test
    public void testPuedeMoverse() {
        System.out.println("puedeMoverse");
        Celda desde = null;
        Celda hasta = null;
        boolean checkearJaque = false;
        Peon instance = null;
        boolean expResult = false;
        boolean result = instance.puedeMoverse(desde, hasta, checkearJaque);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of puedeReingresar method, of class Peon.
     */
    @Test
    public void testPuedeReingresar() {
        System.out.println("puedeReingresar");
        Celda reingreso = null;
        Peon instance = null;
        boolean expResult = false;
        boolean result = instance.puedeReingresar(reingreso);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of debePromover method, of class Peon.
     */
    @Test
    public void testDebePromover() {
        System.out.println("debePromover");
        Celda celda = null;
        Peon instance = null;
        boolean expResult = false;
        boolean result = instance.debePromover(celda);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitarPromocion method, of class Peon.
     */
    @Test
    public void testQuitarPromocion() {
        System.out.println("quitarPromocion");
        Peon instance = null;
        instance.quitarPromocion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of promover method, of class Peon.
     */
    @Test
    public void testPromover() {
        System.out.println("promover");
        Peon instance = null;
        instance.promover();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
