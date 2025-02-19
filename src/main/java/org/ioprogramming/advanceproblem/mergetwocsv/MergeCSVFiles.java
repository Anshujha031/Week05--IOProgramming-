package org.ioprogramming.advanceproblem.mergetwocsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.exceptions.CsvValidationException;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String filePath1 = "F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\advanceproblem\\mergetwocsv\\st1.csv"; // Path to first CSV file
        String filePath2 = "F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\advanceproblem\\mergetwocsv\\st2.csv"; // Path to second CSV file
        String outputFilePath = "F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\advanceproblem\\mergetwocsv\\MergeFile.csv"; // Output file path

        Map<String, String[]> studentData = new HashMap<>();

        // Read first CSV file and store data in a map
        try (CSVReader reader1 = new CSVReader(new FileReader(filePath1))) {
            String[] header1 = reader1.readNext(); // Read header
            String[] row;

            while ((row = reader1.readNext()) != null) {
                String id = row[0]; // ID
                studentData.put(id, new String[]{row[1], row[2]}); // Store Name and Age
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading first CSV: " + e.getMessage());
            return;
        }

        // Read second CSV file and merge data
        try (CSVReader reader2 = new CSVReader(new FileReader(filePath2));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            String[] header2 = reader2.readNext(); // Read header
            String[] newHeader = {"ID", "Name", "Age", "Marks", "Grade"};
            writer.writeNext(newHeader); // Write new header to output file

            String[] row;
            while ((row = reader2.readNext()) != null) {
                String id = row[0]; // ID
                String[] studentInfo = studentData.get(id); // Get Name and Age

                if (studentInfo != null) {
                    // Write merged data to output file
                    writer.writeNext(new String[]{id, studentInfo[0], studentInfo[1], row[1], row[2]});
                }
            }
            System.out.println("Merging completed successfully!");

        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading second CSV or writing output: " + e.getMessage());
        }
    }
}

