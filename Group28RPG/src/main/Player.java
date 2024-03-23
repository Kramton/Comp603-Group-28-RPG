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
    this.defense = 10;
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

  public boolean isDead()
  {
    if (getHealth() <= 0)
    {
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

  public int getDefense(){
    return this.defense;
  }

  public Item[] getItems(){
    return this.items;
  }

  public void setHealth(int value)
  {
    this.health += value;
  }

  public void setAttack(int value)
  {
    this.attack += value;
  }

  public void setDefense(int value)
  {
    //if defense increases (i.e uses shield) or the attack of the monster is less than or equal to the defese. then just modify defense.
    if (this.defense + value >= 0)
    {
      this.defense += value;
    }
    //if the attack of the monster is greater than current defense, subtract health by the remainder, and make defense 0
    else {
      setHealth(this.defense + value);
      this.defense = 0;
    }
    
  }

  public void setItems(int index, Item item)
  {
    this.items[index] = item;
  }

  public void useItem(int itemIndex)
  {
    //if the item is a potion, add health by the stat of the potion
    if (items[itemIndex].getName().equals("Potion"))
    {
      setHealth(items[itemIndex].getStat());
    }
    //if the item is a sword, add attack by the stat of the sword
    else if (items[itemIndex].getName().equals("Sword"))
    {
      setAttack(items[itemIndex].getStat());
    }
    //if the item is a shield, add defense by the stat of the shield
    else if (items[itemIndex].getName().equals("Shield"))
    {
      setDefense(items[itemIndex].getStat());
    }
  }
}
