package com.example.drake.test2exam;

import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drake on 3/6/15.
 */
public class ParseController {

    public static boolean updateNumber(int number, String column){
        ParseObject p = new ParseObject("NormalClass");
        p.put(column,number);
        p.saveInBackground();
        return true;
    }

    public static boolean upUser(String name, String column){
        //Para tablas que no sean usuarios seria
        //ParseQuery<ParseObject> query2 = ParseQuery.getQuery("NormalClass");
        ParseQuery<ParseUser> query = ParseUser.getQuery();
        try {
            List<ParseUser> o = query.find();
            for(ParseUser u : o) {
                if(!u.getString("username").equalsIgnoreCase(name)){
                    ParseUser p = new ParseUser();
                    p.setUsername(name);
                    p.signUpInBackground();
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean upUserAnotherTable(String name, String column){
        //Para tablas que no sean usuarios seria
        ParseQuery<ParseObject> query = ParseQuery.getQuery("NormalClass");
        try {
            List<ParseObject> o = query.find();
            for(ParseObject u : o) {
                if(!u.getString("username").equalsIgnoreCase(name)){
                    ParseUser p = new ParseUser();
                    p.setUsername(name);
                    p.signUpInBackground();
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }
}
