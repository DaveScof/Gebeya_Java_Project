package com.gebeya.training.java.menu;

/**
 * Created by mativo on 28/11/2016.
 */
public class MenuItem {
    int choice;
    String title;

    public MenuItem(int choice, String title){
        this.choice = choice;
        this.title = title;
    }

    /**
     * Return a description of the menu item, like
     * choice+title
     * @return Menu item title desc
     */
    public String getTitle() {
        return choice +" - "+title;
    }

}
