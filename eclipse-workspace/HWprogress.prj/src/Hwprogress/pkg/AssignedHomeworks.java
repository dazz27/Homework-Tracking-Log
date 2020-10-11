package Hwprogress.pkg;

//import java.io.*;
import java.util.Date;

public class AssignedHomeworks {
	private int hwID;
	private int empID; 
	private int studID; 
	Date tdate = new Date(); 
	private int score;
	private boolean checked; 
	

	public AssignedHomeworks(int hwID, int empID, int studID, Date tdate, int score, boolean checked) {
		super();
		this.hwID = hwID;
		this.empID = empID;
		this.studID = studID;
		this.tdate = tdate;
		this.score = -1;
		this.checked = checked;
	}

	public AssignedHomeworks() {
		super();
		this.hwID = 0;
		this.empID = 0;
		this.studID = 0;
		this.tdate = null;
		this.score = -1;
		this.checked = false;
	}

	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public int getStudID() {
		return studID;
	}
	public void setStudID(int studID) {
		this.studID = studID;
	}
	public int getHwID() {
		return hwID;
	}
	public void setHwID(int hwID) {
		this.hwID = hwID;
	}
	public Date getDate() {
		return tdate;
	}
	public void setDate(Date tdate) {
		this.tdate = tdate;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean getChecked() {
		return checked;
	}
	
}
