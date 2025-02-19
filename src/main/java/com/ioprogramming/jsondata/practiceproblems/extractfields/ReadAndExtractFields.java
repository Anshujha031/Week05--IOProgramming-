package com.ioprogramming.jsondata.practiceproblems.extractfields;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

public class ReadAndExtractFields {
    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("F:\\CG-Training\\week05-IoProgramming\\Dat02\\src\\main\\java\\com\\ioprogramming\\jsondata\\practiceproblems\\extractfields\\user.json");

            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

            String name = jsonObject.get("name").getAsString();
            String email = jsonObject.get("email").getAsString();

            System.out.println("name : " + name);
            System.out.println("email : " + email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
