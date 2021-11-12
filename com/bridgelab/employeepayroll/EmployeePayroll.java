package com.bridgelab.employeepayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayroll {

	List<EmployeeData> employeeList = new ArrayList<EmployeeData>();
	private static final String FILE_PATH ="D:\\Bridgelabz\\java\\EmployeePayRoll\\src\\com\\labz\\employeepayroll\\EmployeePayRoll.txt";
    Scanner scanner = new Scanner(System.in);

    public void readEmployeeData()
    {
        System.out.println("Enter Employee Id");
        int id = scanner.nextInt();
        System.out.println("Enter Employee Name");
        String Name = scanner.next();
        System.out.println("Enter the salary");
        double salary = scanner.nextInt();
        employeeList.add(new EmployeeData(id, Name, salary));
    }

    public void writeEmployeeData() 
    {
        System.out.println("Writing Employee Pay Roll Data \n"+employeeList);
    }
    
	
	public void addEmployee(EmployeeData employee) {
        employeeList.add(employee);
    }

    public void writeEmployeeDataToFile() {
        checkFile();
        StringBuffer empBuffer = new StringBuffer();
        employeeList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            empBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(FILE_PATH), empBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void checkFile() {
        File file = new File(FILE_PATH);
        try {

            if (!file.exists()) {
                //if not creating a new file
                file.createNewFile();
                System.out.println("Created a file at " + FILE_PATH);
            }
        } catch (IOException e1) {
            System.err.println("Problem encountered while creating a file");
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(FILE_PATH).toPath()).count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entries;
    }
    
    public void printData()
    {
        try
        {
            Files.lines(Paths.get(FILE_PATH)).forEach(System.out::println);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public long readDataFromFile() {
        try {
            String data = Files.readString(Paths.get(FILE_PATH));
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countEntries();
    }
    
    public static void main(String[] args) {
		System.out.println("welcome to employee pay roll service");
		EmployeePayRoll employeePayRoll = new EmployeePayRoll();
		employeePayRoll.readEmployeeData();
		employeePayRoll.writeEmployeeData();
		employeePayRoll.writeEmployeeDataToFile();
		employeePayRoll.printData();
	}
}