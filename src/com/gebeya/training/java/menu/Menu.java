package com.gebeya.training.java.menu;

import com.gebeya.training.java.Dashboard;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mativo on 28/11/2016.
 */
public class Menu {
    private ArrayList<MenuItem> items;
    private Dashboard dashboard;
    private Scanner keyboard;



    public Menu(Dashboard d){
        this.dashboard = d;
        items = new ArrayList<>();
    }

    /**
     * Add a new {@link MenuItem}
     * @param choice The number of the menu Item
     * @param title The description of the {@link MenuItem}
     */
    public void addMenuItem(int choice, String title) {
        MenuItem m = new MenuItem(choice, title);
        items.add(m);
    }

    /**
     * Print all the options available for the current menu.
     */
    public void show() {
        String s = "";
        for (MenuItem m: items){
            s += m.getTitle() +"\n";
        }

        System.out.println("Enter:\n"+s);
        getInputChoice();
    }

    /**
     * Check if the user's choice is valid
     * Implemented in the subclasses
     * @param choice The number the user selects
     * @return TRUE if the choice exists, FALSE if it doesn't
     */
    public boolean isValidChoice(int choice){

        return false;
    }

    /**
     * Implemented in the subclasses
     * Accept the user's choice and take action.
     */
    public void processChoice(int choice) {

    }

    public void getInputChoice (){
        int userChoice = keyboard.nextInt();
        processChoice(userChoice);

    }



}
