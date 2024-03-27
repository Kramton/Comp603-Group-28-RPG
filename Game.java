/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cqm0237
 */
public class Game{
  private Player player;
  private int room;

  public Game(){
    this.player = new Player();
    this.room = 1;
  }

  public void start(Player player, int room){

      //main main game loop
    while (!(player.isDead()) && room <= 5){

      OutputHandler oHandler = new OutputHandler();
      InputHandler iHandler = new InputHandler();
      Random rand = new Random();
      Scanner scan = new Scanner(System.in);
      
      System.out.println("You are in room " + room);
      System.out.println(oHandler.printPlayerStatus(player));
      
      //spawn monster
      //Put all the monsters in the array, pick a random one to spawn
      Goblin goblin = new Goblin(rand);
      Ogre ogre = new Ogre(rand);
      Monster[] monsters = {goblin, ogre};
      Monster monster = monsters[rand.nextInt(monsters.length)];
      
      if (!(monster.isDead()))
      {
          oHandler.printMonsterStatus(monster);
      }
      
      System.out.println(oHandler.printMenu());
      
      int choice = scan.nextInt();
      
      switch(choice){
          
          case 1:
              System.out.println("You are attacking " + monster.getName() + "!");
              iHandler.attack(player, monster);
              break;
          case 2:
              System.out.println("Which item number do you want to use (1-5)");
              //to-do: verify that number is within range 1-5;
              int itemIntex = scan.nextInt();
              iHandler.useItem(player, itemIntex);
          case 3:
              oHandler.printHelp();
          case 4:
              //save
              break;
          case 5:
              //quit
              break;
      }
      System.out.println("");
      //print available items, if no item, then can't use
      //if there is item: prompt 
      //start combat
      //combat ends
      //drop item
      room++;
    }
  }

  public void combat(Player player, Monster monster)
  {
    
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return this.player;
  }

  public void setRoom(int room) {
    this.room = room;
  }
  
  public int getRoom() {
    return this.room;
  }
}
