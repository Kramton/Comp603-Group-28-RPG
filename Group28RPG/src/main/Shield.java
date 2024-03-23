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
public class Shield extends Item {
  
  public Shield(Random rand)
  {
    super("Shield",rand.nextInt(10) + 5);
  }

  public Shield()
  {
    super();
  }
}
