package Hwprogress.pkg;

//import java.io.*;

public class Employee {
	private int empID; 
	private String jobTitle;
	private String fName;
	private String LName;
	private String empPwd;
	
	public Employee(int empID, String jobTitle, String fName, String lName, String empPwd) {
		super();
		this.empID = empID;
		this.jobTitle = jobTitle;
		this.fName = fName;
		this.LName = lName;
		this.empPwd = empPwd;
	}


	public Employee() {
		super();
		this.empID = 0;
		this.setJobTitle("");
		this.fName = "";
		this.LName = "";
	}
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int actID) {
		this.empID = actID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getEmpPwd() {
		return empPwd;
	}
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}
	
}
