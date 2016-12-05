package com.gebeya.training.java.menu;

import com.gebeya.training.java.Dashboard;

/**
 * Created by gebeya-admin on 11/29/16.
 */
public class ClientMenu extends Menu {

    public ClientMenu(Dashboard d) {
        super(d);

        addMenuItem(1, "Login");
        addMenuItem(2, "Register");
        addMenuItem(3, "View Projects");
        addMenuItem(4, "Add Project");

    }

    @Override
    public void processChoice(int choice) {

        switch (choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;

        }
    }

    @Override
    public boolean isValidChoice(int choice) {
        if (choice < 1 || choice > 4)
            return false;
        else
            return true;
    }
}
