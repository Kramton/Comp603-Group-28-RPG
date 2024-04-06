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

    public void printPlayerStatus(Player player) {
        //print out player stat
        String out = "";
        out += "Your current stats:\n";
        out += "Health: " + player.getHealth() + "\n";
        out += "Attack: " + player.getAttack() + "\n";
        out += "Defense: " + player.getDefense() + "\n";

        System.out.println(out);
    }

    public void printPlayerItems(Player player) {
        String out = "";

        String itemList = "";
        for (int i = 1; i <= player.getItems().length; i++) {
            itemList += "Item " + i + ": " + printItem(player.getItems()[i - 1]) + "\n";
        }
        out += "Items: \n" + itemList;
        System.out.println(out);
    }

    public void printMonsterStatus(Monster monster) {
        System.out.println(monster.getName() + " has "
                + monster.getHealth() + " health and " + monster.getAttack() + " attack");
    }

    public String printItem(Item item) {
        if (item != null) {
            return item.getName() + " " + item.getStat();
        }
        return "empty";

    }

    public String printMenu() {
        String out = "";
        out += "1. Combat\n";
        out += "2. See Stats\n";
        out += "3. See Items\n";
        out += "4. Use Item\n";
        out += "5. Help Menu\n";
        out += "6. Save Game\n";
        out += "7. Quit\n";

        return out;
    }

    public static void welcome() {
        System.out.println("==============================");
        System.out.println("| WELCOME TO ESCAPE DUNGEON! |");
        System.out.println("==============================");
    }

    public static void mainMenu() {
        System.out.println("======== Main Menu ========");
        System.out.println(" 1. New Game");
        System.out.println(" 2. Load Saved Game");
        System.out.println(" 3. Quit Game");
        System.out.println("===========================");
    }

    void printHelp() {
        Game game = new Game();

        System.out.println("=============================== HELP ==============================");
        System.out.println(" + Defeat the monster in each room to advance to the next level!");
        System.out.println(" + After clearing the room, you will receive a random item.");
        System.out.println(" + Defeat the Boss at room " + game.maxRoom() + " to beat the game!");
        System.out.println(" + Use swords to increase your damage!");
        System.out.println(" + Use shields to increase your defense!");
        System.out.println(" + Use potions to heal yourself!");
        System.out.println(" + Don't forget to save game!");
        System.out.println("===================================================================");
    }

}
