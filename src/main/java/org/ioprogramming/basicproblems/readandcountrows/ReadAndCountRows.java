package org.ioprogramming.basicproblems.readandcountrows;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class ReadAndCountRows {
    public static void main(String[] args) {
        try(CSVReader cr = new CSVReader(new FileReader("F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\basicproblems\\readandcountrows\\input.csv"))){
            String[] s;
            int count = -1;
            while((cr.readNext())!=null){
                count++;
            }
            System.out.println("Count : " + count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
