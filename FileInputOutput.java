/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.*;

/**
 *
 * @author cqm0237
 */
public class FileInputOutput {

    private BufferedReader br;
    private PrintWriter pw;

    public FileInputOutput() {
        try {
            this.br = new BufferedReader(new FileReader("./savedData/save.txt"));
            this.pw = null;
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    //save game
    public void write(Game game) {
        try {
            //empties the file before writing
            this.pw = new PrintWriter(new FileOutputStream("./savedData/save.txt"));
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        
        String str = "\n";
        Player player = game.getPlayer();
        int room = game.getRoom();
        Item[] items = player.getItems();

        str += player.getHealth() + "\n";
        str += player.getAttack() + "\n";
        str += player.getDefense() + "\n";

        for (int i = 0; i < 5; i++) {
            if (items[i] != null) {
                str += items[i].getName() +" " + items[i].getStat() + "\n";
            } 
            else {
                str += "\n";
            }
        }
        str += room + "\n";
        
        System.out.println("Progress saved!");

        pw.println(str);
        pw.close();

    }

    public boolean fileEmpty() {
        String line = "";
        try {
            if ((line = br.readLine()) == null) {
                return true;
            }
            //br.close();
        } 
        catch (IOException e) {
            System.out.println("IO Exception");
        }
        
        return false;
    }

    
    //load game
    public Game read() {
        String line;
        
        Game game = new Game(); // game.player is empty
        Player player = game.getPlayer(); // it's gonna be pass by reference
        int room = game.getRoom(); // passed by value, need to save to "game"'s room

        try {
            for (int i = 1; i < 10; i++) {
                if ((line = br.readLine()) != null){

                    switch (i) {
                        case 1:
                            player.setHealth(Integer.parseInt(line));
                            break;
                        case 2:
                            player.setAttack(Integer.parseInt(line));
                            break;
                        case 3:
                            player.setDefense(Integer.parseInt(line));
                            break;
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            // break the line
                            // save item

                                // loops through, creates an item, split the string and 
                                //saves name and stat into Item,
                                // then save item to item array
                            if (!line.equals("")) {
                                Item item = null;
                                String[] str = line.split(" ");
                                if (str[0].equals("Sword")) {
                                    item = new Sword();
                                    item.setName(str[0]);
                                    item.setStat(Integer.parseInt(str[1]));
                                    player.setItems(i - 4, item);
                                } 
                                else if (str[0].equals("Shield")) {
                                    item = new Shield();
                                    item.setName(str[0]);
                                    item.setStat(Integer.parseInt(str[1]));
                                    player.setItems(i - 4, item);
                                } 
                                else if (str[0].equals("Potion")) {
                                    item = new Potion();
                                    item.setName(str[0]);
                                    item.setStat(Integer.parseInt(str[1]));
                                    player.setItems(i - 4, item);
                                } 
                                else {
                                    player.setItems(i - 4, null);
                                }
                                break;
                            }
                            
                            break;
                        case 9:
                            room = Integer.parseInt(line);
                            game.setRoom(room);
                            break;
                    }
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
