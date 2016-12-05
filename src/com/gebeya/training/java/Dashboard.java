package com.gebeya.training.java;

import com.gebeya.training.java.menu.*;

import java.util.ArrayList;

/**
 * Created by mativo on 28/11/2016.
 */
public class Dashboard {

    private static final String GREETING = "Welcome to Gebeya Mobile Enterprise Application!";

    private MainMenu mainMenu;
    private ClientMenu clientMenu;
    private TalentMenu talentMenu;

    private ArrayList <MenuItem> lists;


    private Menu activeMenu;

    public Dashboard(){

        createMenus();
        setActiveMenu(mainMenu);
    }

    public void start(){
        showGreeting();
        activeMenu.show();
        activeMenu.getInputChoice();
    }

    public void createMenus(){
        mainMenu = new MainMenu(this);
        clientMenu = new ClientMenu(this);
        talentMenu = new TalentMenu(this);

    }

    public void setActiveMenu(Menu menu){
        this.activeMenu = menu;
        activeMenu.show();
    }

    public void showGreeting(){
        System.out.println(GREETING);
    }


}
