/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omm.assingment;

import java.util.Random;

/**
 *
 * @author Rusiru
 */
public class RandomSingleObject {
   private static Random randomObject = new Random();

   private RandomSingleObject(){}

   public static Random getRandomSingleObject(){
      return randomObject;
   }

}
