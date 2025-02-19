package org.ioprogramming.advanceproblem.convertcsvtojavaobject;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;


class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private double marks;

    public Student(int id, String firstName, String lastName, int age, double marks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student { ID: " + id + ", Name: " + firstName + " " + lastName +
                ", Age: " + age + ", Marks: " + marks + " }";
    }
}

public class CSVToJavaObject {
    public static void main(String[] args) {
        String filePath = "F:\\CG-Training\\week05-IoProgramming\\src\\main\\java\\org\\ioprogramming\\advanceproblem\\convertcsvtojavaobject\\data.csv";
        List<Student> studentList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Read header (ignore)
            String[] row;

            while ((row = reader.readNext()) != null) {
                int id = Integer.parseInt(row[0]);
                String firstName = row[1];
                String lastName = row[2];
                int age = Integer.parseInt(row[3]);
                double marks = Double.parseDouble(row[4]);

                Student student = new Student(id, firstName, lastName, age, marks);
                studentList.add(student);
            }

            // Print all student objects
            for (Student student : studentList) {
                System.out.println(student);
            }

        } catch (IOException | CsvValidationException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
