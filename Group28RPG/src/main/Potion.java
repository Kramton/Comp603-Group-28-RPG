/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.Random;

/**
 *
 * @author cqm0237
 */
public class Potion extends Item {
  
  public Potion(Random rand) {
    super("Potion",rand.nextInt(20) + 20);
  }

  public Potion()
  {
    super();
  }
}
