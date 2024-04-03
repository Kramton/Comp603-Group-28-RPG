/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.*;

/**
 *
 * @author cqm0237
 */
public class Player {

    private int health;
    private int attack;
    private int defense;
    private Item[] items;

    public Player() {
        this.health = 100;
        this.attack = 10;
        this.defense = 5;
        this.items = new Item[5];
    }

    /*
  public Player(FileReader attributes) {
    try {
      FileReader fr = new FileReader("./save.txt");
      BufferedReader inputStream = new BufferedReader(fr);
      String line = null;
      
      while((line=inputStream.readLine())!=null) {
      ///read inputs, convert to int, and assign to attributes
        System.out.println(line);
      }
      inputStream.close();
    }
      
    catch(FileNotFoundException e) {
      System.out.println("File not found.");
    }
    catch(IOException e) {
    System.out.println("Error reading from file " + "save.txt");
    }
    }
     */
    public boolean isDead() {
        if (getHealth() <= 0) {
            return true;
        }
        return false;
    }

    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public Item[] getItems() {
        return this.items;
    }

    public void setAttack(int value) {
        this.attack = value;
    }

    public void setDefense(int value) {
        this.defense = value;
    }

    public void setHealth(int value) {
        this.health = value;
    }

    public void changeHealth(int value) {
        this.health += value;
    }

    public void changeAttack(int value) {
        this.attack += value;
    }

    public void changeDefense(int value) {
        
        //if defense increases (i.e uses shield) or the attack of the monster is less than or equal to the defese. then just modify defense.
        if (value > 0) {
            this.defense += value;
        } //if the attack of the monster is greater than current defense, subtract health by the remainder
        else {
            if (this.defense < (-value)){
                changeHealth(this.defense + value);
                int difference = this.defense + value;
                System.out.println("You take " + (-difference) + " damage");
            }
            else if(this.defense >= (-value)){
                System.out.println("Your defense is too high. You don't take damage!");
            }
        }
    }

    public void setItems(int index, Item item) {
        this.items[index] = item;
    }
}
