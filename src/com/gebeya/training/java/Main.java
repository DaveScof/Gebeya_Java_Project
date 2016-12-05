package com.gebeya.training.java;

import com.gebeya.training.java.db.SQLConnection;

/**
 * Created by mativo on 22/11/2016.
 */
public class Main {

    public static void main(String[] args) {
        SQLConnection conn = new SQLConnection();

        Dashboard mainDashboard = new Dashboard();
        mainDashboard.start();

    }

}
