package com.gebeya.training.java.menu;

import com.gebeya.training.java.Dashboard;

/**
 * Created by mativo on 28/11/2016.
 */
public class MainMenu extends Menu {

    public MainMenu(Dashboard d){
        super(d);

        /* Create the menuItem options */
        addMenuItem(1, "Continue as Talent");
        addMenuItem(2, "Continue as Client");
        addMenuItem(0, "Back / Exit");
    }

    @Override
    public void processChoice(int choice) {

        switch (choice){
            case 1:
                System.out.println("Processing choice -> 1: ");
                break; 
            case 2:
                System.out.println("Processing choice -> 2: ");
                break;
            case 0:
                System.out.println("Processing choice -> 0: ");
                break;

            default:
                System.out.println("Wrong input choice!");
                break;

        }
    }


    @Override
    public boolean isValidChoice(int choice) {
        return false;

    }
}
