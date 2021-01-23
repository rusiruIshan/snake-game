/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omm.assingment;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Rusiru
 */
public class JObjectFactory {
    
    public static JComponent getObject(String shapeType){
      if(shapeType == null){
         return null;
      }		
      if(shapeType.equalsIgnoreCase("JButton")){
         return new JButton();
         
      } else if(shapeType.equalsIgnoreCase("JPanel")){
         return new JPanel();
      }
      
      return null;
   }
}
