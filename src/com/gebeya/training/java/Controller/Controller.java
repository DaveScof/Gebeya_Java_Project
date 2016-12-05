package com.gebeya.training.java.Controller;

import com.gebeya.training.java.db.SQLConnection;

import java.util.ArrayList;

/**
 * Created by gebeya-admin on 12/5/16.
 */
public abstract class Controller <T>{
    protected SQLConnection db;
    protected ArrayList<T> items;
    protected String table_name;

    public Controller (SQLConnection db, String table){
        this.db = db;
        this.table_name = table;
    }

    public ArrayList<T> getItems (){
        return items;
    }

    public abstract boolean save (T t);
    public abstract boolean update (T t);
    public abstract T getItem ();

}
