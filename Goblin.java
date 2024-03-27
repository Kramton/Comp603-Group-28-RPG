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
public class Goblin extends Monster {
  // create random for:
  // health 40-60
  // attack 15-25
  public Goblin(Random rand) {
    super("Goblin", rand.nextInt(20) + 60, rand.nextInt(10) + 5);
  }
}
