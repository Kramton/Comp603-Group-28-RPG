/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author cqm0237
 */
public class OutputHandler {

    public String printPlayerStatus(Player player) {
        //print out player stat
        String out = "";
        out += "Your current stats:\n";
        out += "Health: " + player.getHealth() + "\n";
        out += "Attack: " + player.getAttack() + "\n";
        out += "Defense: " + player.getDefense() + "\n";

        String itemList = "";
        for (int i = 1; i <= player.getItems().length; i++) {
            itemList += "Item " + i + ": " + printItem(player.getItems()[i - 1]) + "\n";

        }
        out += "Items: \n" + itemList;

        return out;
    }

    public void printMonsterStatus(Monster monster) {
        System.out.println(monster.getName() + " has " + monster.getHealth() + " health");
    }

    public String printItem(Item item) {
        if (item != null) {
            return item.getName() + " " + item.getStat();
        }
        return "empty";

    }

    public String printMenu() {
        return "1. Attack\n2. Use Item\n3. Save Game\n4. Quit";
    }
    
    public static void welcome() {
        System.out.println("===========================");
        System.out.println("| WELCOME TO ESCAPE FIVE! |");
        System.out.println("===========================");
    }
    
    public static void mainMenu() {
        System.out.println("======== Main Menu ========");
        System.out.println(" 1. New Game");
        System.out.println(" 2. Load Saved Game");
        System.out.println(" 3. Quit Game");
        System.out.println("===========================");
    }

    void printHelp() {
        
    }

}