public class Game{
  private Player player;
  private int room;

  public Game(){
    this.player = new Player();
    this.room = 0;
  }

  public void start(Player player, int room){

    while (!player.isDead() && room <= 5){

      OutputHandler handler = new OutputHandler();
      
      System.out.println(handler.printMenu());
      System.out.println("You are in room " + room);
      System.out.println(handler.printPlayerStatus(player));

      
      //print available items, if no item, then can't use
      //if there is item: prompt 
      //start combat
      //combat ends
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