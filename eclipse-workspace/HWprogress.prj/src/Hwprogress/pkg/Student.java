package Hwprogress.pkg;

import java.util.ArrayList;


public class Student {
	private int studID;
	private String fName;
	private String lName;
	private char gradeLvl; // change to gradeLVL
	private String classNum;
	private ArrayList<AssignedHomeworks> hw; // arraylists of assignedhomeworks
	public Student(int studID, String fName, String lName, char gradeLVL, String classNum) {
		super();
		this.studID = studID;
		this.fName = fName;
		this.lName = lName;
		this.gradeLvl = gradeLVL;
		this.classNum = classNum;
		this.hw = new ArrayList<AssignedHomeworks>();
	}
	
	public Student() {
		super();
		this.studID = 0;
		this.fName = "";
		this.lName = "";
		this.gradeLvl = 0;
		this.classNum = "";
		this.hw = new ArrayList<AssignedHomeworks>();
	}
	
	public int getStudID() {
		return studID;
	}
	public void setStudID(int studID) {
		this.studID = studID;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public char getGrade() {
		return gradeLvl;
	}
	public void setGrade(char grade) {
		this.gradeLvl = grade;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	public ArrayList<AssignedHomeworks> getHwList() {
		return hw;
	}
	public void setHwList(ArrayList<AssignedHomeworks> hw) {
		this.hw = hw;
	}
}
