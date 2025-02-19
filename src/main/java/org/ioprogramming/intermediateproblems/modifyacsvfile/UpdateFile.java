package org.ioprogramming.intermediateproblems.modifyacsvfile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public class UpdateFile {
    public static void main(String[] args) {
        String inputFilePath = "F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\intermediateproblems\\modifyacsvfile\\input.csv";
        String outputFilePath = "F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\intermediateproblems\\modifyacsvfile\\UpdatedRecord.csv";

        try (CSVReader csr = new CSVReader(new FileReader(inputFilePath));
             CSVWriter csw = new CSVWriter(new FileWriter(outputFilePath))) {

            // Read header and write it to the new file
            String[] header = csr.readNext();
            if (header != null) {
                csw.writeNext(header);
            }

            String[] record;
            while ((record = csr.readNext()) != null) {
                // Ensure there are at least 5 columns before accessing index 3 (Department) and index 4 (Salary)
                if (record.length > 4 && "IT".equalsIgnoreCase(record[3])) {
                    try {
                        double salary = Double.parseDouble(record[4]);
                        salary *= 1.10; // Increase salary by 10%
                        record[4] = String.format("%.2f", salary); // Format to 2 decimal places
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary format for record: " + String.join(",", record));
                    }
                }
                csw.writeNext(record);
            }

            System.out.println("Update complete. Check the updated file: " + outputFilePath);

        } catch (IOException  | CsvValidationException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}
