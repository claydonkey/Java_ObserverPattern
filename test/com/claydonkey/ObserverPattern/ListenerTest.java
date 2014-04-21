/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.claydonkey.ObserverPattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anthony
 */
public class ListenerTest {
    
    public ListenerTest() {
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
     * Test of addEventHandler method, of class Listener.
     */
    @Test
    public void testAddEventHandler() {
        System.out.println("addEventHandler");
        IEventHandler eventhandler = null;
        Listener instance = new Listener();
        instance.addEventHandler(eventhandler);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Listener.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object o = null;
        EventArgs e = null;
        Listener instance = new Listener();
        instance.update(o, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
