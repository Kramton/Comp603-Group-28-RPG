/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author cqm0237
 */
public class Main { // menu screen

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome! Start a new game or load saved game?");

        boolean isValid = true;
        while (isValid) {
            System.out.println("1. New Game");
            System.out.println("2. Saved Game");
            
            try {
                int choice = scan.nextInt();

                if (choice == 1) {
                    Game game = new Game();
                    game.start(game.getPlayer(), game.getRoom());
                } 
                else if (choice == 2) {
                    FileInputOutput fio = new FileInputOutput();
                    if (!(fio.fileEmpty())) {
                        Game game = fio.read();
                        game.start(game.getPlayer(), game.getRoom());
                    } 
                    else {
                        System.out.println("No saved data. Starting a new game...");
                        Game game = new Game();
                        game.start(game.getPlayer(), game.getRoom());
                    }
                }
                else {
                    throw new InputMismatchException();
                }
                
                isValid = false;
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option (1 or 2).");
                scan.nextLine(); // takes in the invalid input.
            }
        }
        
        //scan.close();
        System.out.println("Thank you for playing the game!");
    }
}
