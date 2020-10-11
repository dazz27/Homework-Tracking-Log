package Hwprogress.pkg;


public class Homework {
	
	private int hwID;
	private String hwsubject;
	 
	public Homework(int hwID, String hwsubject) {
		super();
		this.hwID = hwID;
		this.hwsubject = hwsubject;
	}
	
	public Homework() {
		super();
		this.hwID = 0;
		this.hwsubject = "";
	}
	
	public int getHwID() {
		return hwID;
	}
	public void setHwID(int hwID) {
		this.hwID = hwID;
	}
	public String getSubject() {
		return hwsubject;
	}
	public void setSubject(String hwsubject) {
		this.hwsubject = hwsubject;
	}
	
}
