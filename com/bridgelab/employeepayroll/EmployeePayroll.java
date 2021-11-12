package com.bridgelab.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayroll {

	List<EmployeeData> employeeList = new ArrayList<EmployeeData>();
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
    
	public static void main(String[] args) {
		System.out.println("welcome to employee pay roll service");
		EmployeePayRoll employeePayRoll = new EmployeePayRoll();
		employeePayRoll.readEmployeeData();
		employeePayRoll.writeEmployeeData();
	}
}