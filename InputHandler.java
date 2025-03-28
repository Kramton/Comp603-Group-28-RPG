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
public class InputHandler {

    /**
     * ***
     * Input Handler: Handles Player input Attack Use Item Help Quit 
  ****
     */
    public void pCombat(Player player, Monster monster) {

        Random rand = new Random();
        System.out.println("You are attacking " + monster.getName() + "!");
        
        double luckyStrike = rand.nextDouble(1);
        int multiplier = rand.nextInt(2) + 2;
        
        if(luckyStrike >=0.7){
            System.out.println("You attack crits, gaining " + multiplier + " times the power!");
           System.out.println(monster.getName() + " takes " + player.getAttack()*multiplier + " damage");
            monster.setHealth(monster.getHealth() - player.getAttack()*multiplier); 
        }
        else{
            System.out.println(monster.getName() + " takes " + player.getAttack() + " damage");
            monster.setHealth(monster.getHealth() - player.getAttack());
        }
        
        
        if (monster.getHealth() > 0) {
            System.out.println(monster.getName() + " has " + monster.getHealth() + " HP left");
        } 
        else {
            System.out.println(monster.getName() + " has 0 HP left");
        }

    }

    public void mCombat(Player player, Monster monster) {
        System.out.println(monster.getName() + " attacks!");
        player.changeDefense(monster.getAttack() * -1);//change defense by negative

        if (player.getHealth() > 0) {
            System.out.println("You have " + player.getHealth() + " HP and " + player.getDefense() + " DEF left");
        } 
        else {
            System.out.println("You have 0 HP left");
        }
    }

    public void useItem(Player player, int itemIndex) {
        itemIndex--;

        if (player.getItems()[itemIndex] == null) {
            System.out.println("You have no item in that slot!");
        } //if the item is a potion, add health by the stat of the potion
        else if (player.getItems()[itemIndex].getName().equals("Potion")) {
            player.changeHealth(player.getItems()[itemIndex].getStat());
            System.out.println("Your health has increased by " + player.getItems()[itemIndex].getStat());
            player.setItems(itemIndex, null);
        } //if the item is a sword, add attack by the stat of the sword
        else if (player.getItems()[itemIndex].getName().equals("Sword")) {
            player.changeAttack(player.getItems()[itemIndex].getStat());
            System.out.println("Your attack has increased by " + player.getItems()[itemIndex].getStat());
            player.setItems(itemIndex, null);
        } //if the item is a shield, add defense by the stat of the shield
        else if (player.getItems()[itemIndex].getName().equals("Shield")) {
            player.changeDefense(player.getItems()[itemIndex].getStat());
            System.out.println("Your defense has increased by " + player.getItems()[itemIndex].getStat());
            player.setItems(itemIndex, null);
        }
    }
    public void help() {
        OutputHandler oHandler = new OutputHandler();
        oHandler.printHelp();
    }
}
