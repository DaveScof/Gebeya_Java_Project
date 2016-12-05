package com.gebeya.training.java.menu;

import com.gebeya.training.java.Dashboard;

/**
 * Created by gebeya-admin on 11/29/16.
 */
public class TalentMenu extends Menu {
    public TalentMenu (Dashboard d) {
        super(d);

        addMenuItem(1, "View Profile");
        addMenuItem(2, "View Projects");
        addMenuItem(0, "Go back");

    }

    @Override
    public void processChoice(int choice) {

        switch (choice){
            case 1:
                break;
            case 2:
                break;
            case 0:
                break;
            default:
                break;

        }
    }

    @Override
    public boolean isValidChoice(int choice) {
        if (choice < 0 || choice > 2)
            return false;
        else
            return true;
    }
}
