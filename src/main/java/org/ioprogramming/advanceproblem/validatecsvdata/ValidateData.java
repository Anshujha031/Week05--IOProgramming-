package org.ioprogramming.advanceproblem.validatecsvdata;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

import com.opencsv.exceptions.CsvValidationException;

public class ValidateData {
    public static void main(String[] args) {
        String filePath = "F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\advanceproblem\\validatecsvdata\\data.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"; // Email validation pattern
        String phoneRegex = "^[0-9]{10}$"; // Phone number must be exactly 10 digits

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Read header
            String[] row;

            while ((row = reader.readNext()) != null) {
                String email = row[3];
                String phone = row[4];

                Matcher emailMatcher = emailPattern.matcher(email);
                Matcher phoneMatcher = phonePattern.matcher(phone);

                if (!emailMatcher.matches()) {
                    System.out.println("Invalid Email: " + email + " in row: " + String.join(", ", row));
                }
                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid Phone Number: " + phone + " in row: " + String.join(", ", row));
                }
            }

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
