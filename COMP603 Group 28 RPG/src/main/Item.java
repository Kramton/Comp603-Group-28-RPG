/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author cqm0237
 */
public abstract class Item {

    private String name;
    private int stat;

    public Item(String name, int stat) {
        this.name = name;
        this.stat = stat;
    }

    public Item() {
        this.name = null;
        this.stat = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getStat() {
        return this.stat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }
}
