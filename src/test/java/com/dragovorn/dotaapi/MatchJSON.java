package com.dragovorn.dotaapi;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;

public class MatchJSON {

    // Maybe use Mockito to return this from Dota methods

    public static JSONObject MATCH;

    static {
        try {
            MATCH = new JSONObject(new JSONTokener(new FileInputStream("testgame.json")));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}