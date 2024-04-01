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
public class Game {

    private Player player;
    private int room;
    private final int MAX_ROOM = 10;

    public Game() {
        this.player = new Player();
        this.room = 1;
    }

    public void start(Player player, int room) {
        FileInputOutput fio = new FileInputOutput();

        //main main game loop, represents 1 room
//        while (!(player.isDead()) && room <= 5) {
        while (!(player.isDead()) && room <= MAX_ROOM) {

            OutputHandler oHandler = new OutputHandler();
            InputHandler iHandler = new InputHandler();
            Random rand = new Random();
            Scanner scan = new Scanner(System.in);

            System.out.println("You are in room " + room);

            //spawn monster
            //Put all the monsters in the array, pick a random one to spawn
            Goblin goblin = new Goblin(rand);
            Ogre ogre = new Ogre(rand);
            Boss boss = new Boss(rand);
            Monster[] monsters = {goblin, ogre, boss};
            Monster monster;

//            if (room != 5) {
            if (room != MAX_ROOM) {
                monster = monsters[rand.nextInt(monsters.length - 1)];
            } 
            else {
                monster = monsters[monsters.length - 1];
            }

            oHandler.printMonsterStatus(monster);

            //combat loop
            while (!monster.isDead() && !player.isDead()) {
                System.out.println("Player turn! ");
                System.out.println(oHandler.printMenu());

                System.out.print("> ");

                int choice = scan.nextInt();

                switch (choice) {

                    case 1:
                        iHandler.pCombat(player, monster);
                        if (!monster.isDead()) {
                            System.out.println(monster.getName() + "'s turn! ");
                            iHandler.mCombat(player, monster);
                        }
                        break;
                    case 2:
                        oHandler.printPlayerStatus(player);
                        break;
                    case 3:
                        oHandler.printPlayerItems(player);
                        break;
                    case 4:
                        boolean isValid = false;
                        int itemIndex = 0;
                        while (!isValid) {
                            System.out.println("Which item number do you want to use (1-5)");

                            if (scan.hasNextInt()) { // Check if the next token is an integer
                                itemIndex = scan.nextInt();
                                if (itemIndex > 0 && itemIndex <= 5) {
                                    isValid = true; // Set isValidInput to true to exit the loop
                                } else {
                                    System.out.println("Invalid input. Please enter 1-5");
                                }
                            } 
                            else {
                                System.out.println("Invalid input. Please enter again");
                                scan.next(); // Clear the scanner buffer
                            }
                        }
                        iHandler.useItem(player, itemIndex);
                        break;
                    case 5:
                        oHandler.printHelp();
                        break;
                    case 6:
                        //save game
                        fio.write(this);
                        break;
                    case 7:
                        //quit
                        isValid = false;
                        while (!isValid) {
                            System.out.println("Would you like to save before you quit? 1. Yes 2. No");
                            if (scan.hasNextInt()) {
                                choice = scan.nextInt();
                                if (choice == 1) {
                                    isValid = true;
                                    fio.write(this);
                                    System.out.println("Thank you for playing the game!");
                                    System.exit(0);
                                } 
                                else if (choice == 2) {
                                    isValid = true;
                                    System.out.println("Thank you for playing the game!");
                                    System.exit(0);
                                } 
                                else {
                                    System.out.println("Invalid input");
                                }
                            } 
                            else {
                                System.out.println("Please enter a number");
                                scan.next();
                            }
                        }

                        break;
                }
            }

            if (monster.isDead()) {
                System.out.println("You have defeated " + monster.getName() + "!");
            } 
            else if (player.isDead()) {
                System.out.println("You have been defeated!");
            }

//            if (room != 5 && !player.isDead()) {
            if (room != this.MAX_ROOM && !player.isDead()) {
                Item[] rewards = {new Sword(rand), new Shield(rand), new Potion(rand)};
                Item reward = rewards[rand.nextInt(rewards.length)];
                System.out.println("You have received a " + reward.getName());
                for (int i = 0; i < player.getItems().length; i++) {
                    if (player.getItems()[i] == null) {
                        player.setItems(i, reward);
                        i = player.getItems().length - 1;
                    }
                }
                System.out.println("Moving to the next room...");
            }
            //room++;
            setRoom(room++);
        }
    }

    //Room-loop, represents one combat
    public void combat(Player player, Monster monster, InputHandler iHandler) {
        //while();
        System.out.println("You are attacking " + monster.getName() + "!");
        //iHandler.attack(player, monster);
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

    public int maxRoom() {
        return this.MAX_ROOM;
    }
}
