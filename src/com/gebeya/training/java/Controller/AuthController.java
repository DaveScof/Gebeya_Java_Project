package com.gebeya.training.java.Controller;

import com.gebeya.training.java.db.SQLConnection;
import com.gebeya.training.java.model.Auth;

/**
 * Created by gebeya-admin on 12/5/16.
 */
public class AuthController extends Controller <Auth> {


    public AuthController(SQLConnection db, String table){
        super(db, table);
    }
    @Override
    public boolean save(Auth auth) {
        return false;
    }

    @Override
    public boolean update(Auth auth) {
        return false;
    }

    @Override
    public Auth getItem() {
        return null;
    }
}
