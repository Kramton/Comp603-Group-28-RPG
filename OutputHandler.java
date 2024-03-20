public class OutputHandler{


  public String printPlayerStatus(Player player) {
    //print out player stat
    String out = "";
    out += "Your current stats:\n";
    out += "Health: " + player.getHealth() + "\n";
    out += "Attack: " + player.getAttack() + "\n";
    out += "Defense: " + player.getDefense() + "\n";

    String itemList = "";
    for (int i = 0; i < player.getItems().length; i++)
      {
        itemList +="Item " + i + ": " + printItem(player.getItems()[i]) + "\n";
        
      }
    out += "Items: \n" + itemList;

    return out;
  }

  public String printMonsterStatus(Monster monster) {
    return monster.getName() + " has " + monster.getHealth() + " health";
  }

  public String printItem(Item item) {
    return item.getName() + " " + item.getStat();
  }

  public String printMenu()
  {
    return "1. Attack\n2. Use Item\n3. Save Game\n4. Quit";
  }
  
}