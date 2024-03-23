/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.Scanner;
/**
 *
 * @author cqm0237
 */

public class Main { // menu screen
  public static void main(String[] args) {

    System.out.println("Welcome! New game or saved game?");
    System.out.println("1. New Game");
    System.out.println("2. Saved Game");
    Scanner scan = new Scanner(System.in);

    int choice = scan.nextInt();

    //handle non integer inoputs pls
    while(choice != 1 && choice != 2) 
    {
        System.out.println("Invalid input");
        choice = scan.nextInt();
    }
    if (choice == 1){
        Game game = new Game();
        game.start(game.getPlayer(), game.getRoom());
    }
       
    else if (choice == 2) {
      FileInputOutput fio = new FileInputOutput();
      if (!(fio.fileEmpty()))
        {
            Game game = fio.read();
            game.start(game.getPlayer(), game.getRoom());
        }
      else
      {
        System.out.println("No saved data. Starting a new game...");
        Game game = new Game();
        game.start(game.getPlayer(), game.getRoom());
      }
    }

    //scan.close();
    System.out.println("Thank you for playing the game!");
  }
}
