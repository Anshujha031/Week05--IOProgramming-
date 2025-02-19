package org.ioprogramming.basicproblems.writecsvfile;

import com.opencsv.CSVWriter;

import java.io.FileWriter;

public class WriteDataToaCSVFile {
    public static void main(String[] args) {
        try(CSVWriter cw = new CSVWriter(new FileWriter("F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\basicproblems\\writecsvfile\\write"))){
          String[] header = {"ID","Name","Department","Salary"};
            String[] emp1 = {"104", "Alice Williams", "Finance", "62000"};
            String[] emp2 = {"105", "Bob Johnson", "Sales", "58000"};
            String[] emp3 = {"106", " Johnson", "Sales", "580"};
            String[] emp4 = {"107", "Neeraj", "Sales", "58"};
            String[] emp5 = {"108", "Neeli", "Tech", "10000"};

            cw.writeNext(header);
            cw.writeNext(emp1);
            cw.writeNext(emp2);

            System.out.println("CSV file written successfully ");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
