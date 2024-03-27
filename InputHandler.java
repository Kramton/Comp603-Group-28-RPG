/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author cqm0237
 */
public class InputHandler {
    
    /*****
    Input Handler: Handles Player input 
    Attack 
    Use Item 
    Help 
    Quit 
  *****/
    
    public void attack(Player player, Monster monster){
        monster.setHealth(monster.getHealth() - player.getAttack());
    }
    
    public void useItem(Player player, int itemIndex){
        //if the item is a potion, add health by the stat of the potion
        if (player.getItems()[itemIndex].getName().equals("Potion"))
        {
          player.setHealth(player.getItems()[itemIndex].getStat());
        }
        //if the item is a sword, add attack by the stat of the sword
        else if (player.getItems()[itemIndex].getName().equals("Sword"))
        {
          player.setAttack(player.getItems()[itemIndex].getStat());
        }
        //if the item is a shield, add defense by the stat of the shield
        else if (player.getItems()[itemIndex].getName().equals("Shield"))
        {
          player.setDefense(player.getItems()[itemIndex].getStat());
        }
    }
    
    public void help(){
        OutputHandler oHandler = new OutputHandler();
        oHandler.printHelp();
    }
    
}
