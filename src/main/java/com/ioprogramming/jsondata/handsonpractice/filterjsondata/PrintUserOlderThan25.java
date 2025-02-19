package com.ioprogramming.jsondata.handsonpractice.filterjsondata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;

public class PrintUserOlderThan25 {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.readTree(new File("F:\\CG-Training\\week05-IoProgramming\\Dat02\\src\\main\\java\\com\\ioprogramming\\jsondata\\practiceproblems\\parsejsonandfilter\\user.json"));

            ArrayNode flterArray = objectMapper.createArrayNode();

            for(JsonNode node : jsonArray){
                if(node.get("age").asInt()>25){
                    flterArray.add(node);
                }
            }
            String filterJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(flterArray);
            System.out.println(filterJson);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
