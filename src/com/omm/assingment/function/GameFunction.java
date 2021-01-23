/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omm.assingment.function;

import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Rusiru
 */
public interface GameFunction {
    
    public int snakeGroup (JButton[] lengthButton, int gu, JPanel panel1,int [] lengthButtonX,int [] lengthButtonY, boolean isEat);
    
    public boolean createFirstSnake (JButton[] lengthButton, JPanel panel1,int [] lengthButtonX,int [] lengthButtonY);
    
    public void gameOver (Thread myThread, JTextArea scoreTextArea, int score, Timer timer);
    
    public int increaseScore  (int score, JTextArea scoreTextArea);
}
