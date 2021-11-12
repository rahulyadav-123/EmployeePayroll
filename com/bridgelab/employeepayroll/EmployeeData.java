package com.bridgelab.employeepayroll;

public class EmployeeData {
	public int empId;
	public String empName;
	public double empSalary;
	
	public EmployeeData(int empId, String empName, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "EmployeeData [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

}