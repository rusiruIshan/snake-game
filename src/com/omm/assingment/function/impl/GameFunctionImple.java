/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omm.assingment.function.impl;

import com.omm.assingment.JObjectFactory;
import com.omm.assingment.RandomSingleObject;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.omm.assingment.function.GameFunction;
import java.util.Timer;
import javax.swing.JTextArea;

/**
 *
 * @author Rusiru
 */

public class GameFunctionImple implements GameFunction{

       
    @Override
    public int snakeGroup(JButton[] lengthButton, int gu, JPanel panel1,int [] lengthButtonX,int [] lengthButtonY,boolean isEat) {
        Random random = RandomSingleObject.getRandomSingleObject();
//        if(isEat){
        lengthButton[gu] = (JButton) JObjectFactory.getObject("JButton");
        lengthButton[gu].setEnabled(false);
        panel1.add(lengthButton[gu]);
//        }
        
        int a = 10 + (10 * random.nextInt(48));
        int b = 10 + (10 * random.nextInt(23));
        lengthButtonX[gu] = a;
        lengthButtonY[gu] = b;
        lengthButton[gu].setBounds(a,b,10,10);
        if(isEat){
          lengthButton[gu].setBounds(a,b,10,10);  
            System.out.println(gu);
        }
        
        return ++gu;
        
    }

    @Override
    public boolean createFirstSnake(JButton[] lengthButton, JPanel panel1,int [] lengthButtonX,int [] lengthButtonY) {
        for(int i=0; i < 3; i++){
            lengthButton[i] = new JButton("lb"+ i);
            lengthButton[i].setEnabled(false);
            panel1.add(lengthButton[i]);
            lengthButton[i].setBounds(lengthButtonX[i], lengthButtonY[i], 10, 10);
            lengthButtonX[i+1] = lengthButtonX[i] - 10;
            lengthButtonY[i+1] = lengthButtonY[i];
        }
        return true;
    }

    @Override
    public void gameOver(Thread myThread, JTextArea scoreTextArea, int score, Timer timer) {
        timer.cancel();
        timer.purge();
        scoreTextArea.setText("Game over ->>" + score);
        try{
            myThread.join();
        }catch(InterruptedException ex){}
    }
    
}
