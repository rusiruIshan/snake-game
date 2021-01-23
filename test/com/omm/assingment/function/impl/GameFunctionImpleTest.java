/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omm.assingment.function.impl;

import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rusiru
 */
public class GameFunctionImpleTest {
    
    public GameFunctionImpleTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSnakeGroup() {
        System.out.println("snakeGroup");
        int gu = 0;
        JButton[] lengthButton = new JButton[200];
        JPanel panel1 = new JPanel();
        int[] lengthButtonX = new int[600];
        int[] lengthButtonY = new int[600];
        GameFunctionImple instance = new GameFunctionImple();
        int expResult = 1;
        boolean isEat = false;
        int result = instance.snakeGroup(lengthButton, gu, panel1, lengthButtonX, lengthButtonY, isEat);
        assertEquals(expResult, result);
        
    }

   
    @Test
    public void testCreateFirstSnake() {
        System.out.println("createFirstSnake");
        JButton[] lengthButton = new JButton[200];
        JPanel panel1 = new JPanel();
        int[] lengthButtonX = new int[600];
        int[] lengthButtonY = new int[600];
        GameFunctionImple instance = new GameFunctionImple();
        boolean expResult = true;
        boolean result = instance.createFirstSnake(lengthButton, panel1, lengthButtonX, lengthButtonY);
        assertEquals(expResult, result);

    }

    
    @Test
    public void testGameOver() {
        System.out.println("gameOver");
        Thread myThread = new Thread();
        JTextArea scoreTextArea = new JTextArea();
        int score = 0;
        Timer timer = new Timer();
        GameFunctionImple instance = new GameFunctionImple();
        instance.gameOver(myThread, scoreTextArea, score, timer);

    }

    /**
     * Test of increaseScore method, of class GameFunctionImple.
     */
    @Test
    public void testIncreaseScore() {
        System.out.println("increaseScore");
        int score = 0;
        JTextArea scoreTextArea = new JTextArea();
        GameFunctionImple instance = new GameFunctionImple();
        int expResult = 1;
        int result = instance.increaseScore(score, scoreTextArea);
        assertEquals(expResult, result);
        
    }
    
}
