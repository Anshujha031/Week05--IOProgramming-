package org.ioprogramming.basicproblems.readcsvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

import java.io.FileReader;
import java.sql.SQLOutput;

public class ReadAndPrintCSVFile {
    public static void main(String[] args)  {
        try(CSVReader r = new CSVReader(new FileReader("F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\basicproblems\\readcsvfile\\input.csv"))){
            String[] line;
            while((line = r.readNext()) != null){
                System.out.println("ID: " + line[0] + " , Name: " + line[1]);
            }


        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
