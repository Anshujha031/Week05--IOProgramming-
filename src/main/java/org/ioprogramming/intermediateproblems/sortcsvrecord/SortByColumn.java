package org.ioprogramming.intermediateproblems.sortcsvrecord;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.opencsv.exceptions.CsvValidationException;

public class SortByColumn {
    public static void main(String[] args) {
        String filePath = "F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\intermediateproblems\\sortcsvrecord\\Emp.csv"; // Path to your CSV file
        List<String[]> employees = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Read header
            String[] row;

            while ((row = reader.readNext()) != null) {
                employees.add(row); // Store employee data
            }

            // Sort employees by salary (column index 4) in descending order
            employees.sort((a, b) -> Double.compare(Double.parseDouble(b[4]), Double.parseDouble(a[4])));

            // Print header
            System.out.println(Arrays.toString(header));

            // Print top 5 highest-paid employees
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                System.out.println(Arrays.toString(employees.get(i)));
            }

        } catch (IOException | CsvValidationException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
