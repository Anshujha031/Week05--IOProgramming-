package org.ioprogramming.intermediateproblems.searchrecord;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class SearchForARecord {
    public static void main(String[] args) {
        String filePath = "F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\intermediateproblems\\searchrecord\\employee.csv";
        String searchName = "John Doe";

        try(CSVReader cs = new CSVReader(new FileReader(filePath))){

            String[] s;

            cs.readNext();
            while((s = cs.readNext()) != null)
            {
               String fullName = s[1] ;
             if(fullName.equalsIgnoreCase(searchName)){
                 System.out.println("Id: " + s[0] + ", Name: " + s[1]  + ", Department: " + s[2] + ", Salary: " + s[3]);
                 break;
             }else{
                 System.out.println("Not Found");
             }


            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
