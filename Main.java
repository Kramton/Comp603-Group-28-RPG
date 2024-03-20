// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import java.util.Scanner;


public class Main { // menu screen
  public static void main(String[] args) {

    System.out.println("Welcome! New game or saved game?");
    System.out.println("1. New Game");
    System.out.println("2. Saved Game");
    Scanner scan = new Scanner(System.in);

    int choice = scan.nextInt();

    while(choice != 1 || choice != 2) 
    {
      if (choice == 1) {
        Game game = new Game();
        game.start(game.getPlayer(), game.getRoom());
      } 
      else if (choice == 2) {
        FileInputOutput fio = new FileInputOutput();
        Game game = fio.read();
  
        game.start(game.getPlayer(), game.getRoom());
      }
      else {
        System.out.println("Invalid choice.");
      }
    }

    scan.close();

  }

  // @Test
  // void addition() {
  // assertEquals(2, 1 + 1);
  // }
}