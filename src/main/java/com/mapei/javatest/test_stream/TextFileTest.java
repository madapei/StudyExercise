package com.mapei.javatest.test_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/20
 */
class Employee{
    private String name;
    private Integer salary;
    private LocalDate hireDay;

    public Employee(String name, Integer salary, LocalDate hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }
}

public class TextFileTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, LocalDate.parse("1987-12-15"));
        staff[1] = new Employee("Harry Hacker", 55000, LocalDate.parse("1989-10-01"));
        staff[2] = new Employee("Tony Tester", 4000, LocalDate.parse("1990-03-15"));

        try {
            PrintWriter out = new PrintWriter("F:\\test_file\\employee.dat", "UTF-8");
            writeData(staff, out);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try{
            Scanner in = new Scanner(new FileInputStream("F:\\test_file\\employee.dat"), "UTF-8");
            Employee[] newStaff = readData(in);
            for (Employee e : newStaff){
                System.out.println(e);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void writeData(Employee[] employees, PrintWriter out){
        out.println(employees.length);
        for (Employee e : employees){
            writeEmployee(out, e);
        }
    }

    private static void writeEmployee(PrintWriter out, Employee e){
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }

    private static Employee[] readData(Scanner in){
        int n = in.nextInt();
        in.nextLine();

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++){
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    private static Employee readEmployee(Scanner in){
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        Integer salary = Integer.parseInt(tokens[1]);
        LocalDate hireDate = LocalDate.parse(tokens[2]);
        return new Employee(name, salary, hireDate);
    }
}
