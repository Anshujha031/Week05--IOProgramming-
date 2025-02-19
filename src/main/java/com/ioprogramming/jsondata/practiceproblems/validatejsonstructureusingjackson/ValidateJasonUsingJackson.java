package com.ioprogramming.jsondata.practiceproblems.validatejsonstructureusingjackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ValidateJasonUsingJackson {
    public static void main(String[] args) {


        String jsonString = "F:\\CG-Training\\week05-IoProgramming\\Dat02\\src\\main\\java\\com\\ioprogramming\\jsondata\\practiceproblems\\validatejsonstructureusingjackson\\user.json";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(new File(jsonString));
            System.out.println("Valid json : " + jsonNode);
        } catch (Exception e) {
            System.out.println("Invalid json : " + e.getMessage());
        }
    }
}
