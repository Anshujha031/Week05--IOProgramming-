package org.ioprogramming.intermediateproblems.filterrecordstudent;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class FilterRecordFromCSV {
    public static void main(String[] args) {
        try(CSVReader cr = new CSVReader(new FileReader("F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\intermediateproblems\\filterrecord\\student\\student.csv"))){
            String[] str = cr.readNext();
            while((str = cr.readNext()) != null){
                int marks = Integer.parseInt(str[4]);
                if(marks > 80){
                    System.out.println("StudentID: " + str[0] + ", FirstName: " + str[1] + ", LastName: " + str[2] + "Age: " + str[3] + "Marks: " + str[4]);
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
