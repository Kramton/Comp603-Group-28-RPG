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
public class Sword extends Item{
  
  //Random rand = new Random();
  public Sword(Random rand)
  {
    super("Sword",rand.nextInt(10) + 5);
  }

  public Sword()
  {
    super();
  }

  
}
