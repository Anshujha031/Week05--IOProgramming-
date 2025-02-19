package com.ioprogramming.jsondata.handsonpractice.validateanemail;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class EmailValidationUsingJsonSchema {
    public static void main(String[] args) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode schemaNode = objectMapper.readTree(new File("schema.json"));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);


            JsonNode jsonData = objectMapper.readTree(new File("user.json"));

            ProcessingReport report = schema.validate(jsonData);

            // ✅ Print Validation Result
            if (report.isSuccess()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("Invalid JSON!");
                report.forEach(msg -> System.out.println(msg));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
