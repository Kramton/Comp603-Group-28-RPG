import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputOutput {
  private BufferedReader br;
  private PrintWriter pw;

  public FileInputOutput() {
    try {
      this.br = new BufferedReader(new FileReader("save.txt"));
      this.pw = new PrintWriter("save.txt");
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }

  }

  public void write(Game game) {
    String str = "";
    Player player = game.getPlayer();
    int room = game.getRoom();
    Item[] items = player.getItems();

    str += player.getHealth() + "\n";
    str += player.getAttack() + "\n";
    str += player.getDefense() + "\n";

    for (int i = 0; i < 5; i++) {
      if (items[i] != null) {
        str += items[i].getName() + items[i].getStat() + "\n";
      } else {
        str += "\n";
      }
    }
    str += room + "\n";

    pw.println(str);
    pw.close();

  }

  public Game read() {
    String line = "";
    Game game = new Game(); // game.player is empty
    Player player = game.getPlayer(); // it's gonna be pass by reference
    int room = game.getRoom(); // passed by value, need to save to "game"'s room
    try 
    {
      for (int i = 0; i < 9; i++) 
      {
        line = br.readLine();

        switch (i) 
        {
          case 0:
            player.setHealth(Integer.parseInt(line));
            break;
          case 1:
            player.setAttack(Integer.parseInt(line));
            break;
          case 2:
            player.setDefense(Integer.parseInt(line));
            break;
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
            // break the line
            // save item
            for (int j = 3; j <= 7; j++) {
              // loops through, creates an item, split the string and saves name and stat into
              // Item,
              // then save item to item array
              if (line != null) {
                Item item = null;

                String[] str = line.split(" ");
                if (str[0] == "Sword") {
                  item = new Sword();
                  item.setName(str[0]);
                  item.setStat(Integer.parseInt(str[1]));
                  player.setItems(j - 3, item);
                } else if (str[0] == "Shield") {
                  item = new Shield();
                  item.setName(str[0]);
                  item.setStat(Integer.parseInt(str[1]));
                  player.setItems(j - 3, item);
                } else if (str[0] == "Potion") {
                  item = new Potion();
                  item.setName(str[0]);
                  item.setStat(Integer.parseInt(str[1]));
                  player.setItems(j - 3, item);
                }
                else
                {
                  player.setItems(j - 3, null);
                }
              }
            }
            break;
          case 8:
            room = Integer.parseInt(line);
            game.setRoom(room);
            break;
        }
      }
      br.close(); 
    }
      
    catch (IOException e) {
      System.out.println("IO Exception");
    }
    return game;
  }
}