/*
 * Author: Robert Gonzalez 
 * Date: 09/06/2020
 * UTSA Id: Yhs346
 */

/*
 * This class is used to assign student name, student grade level
 * and whether or not student is vegetarian 
 */
public class Student {
	String studentName,studentLevel,vegMessage;
	boolean veg;
	/*
	 * Constructor 
	 * @param name: String Name of student
	 * @param: level:String Grade level of student
	 * @param: vegT: Boolean determining if student is vegetarian
	 */
	Student(String name, String level,boolean vegT){
		this.studentName = name;
		this.studentLevel = level;
		this.veg = vegT;
		
		if(vegT){
			vegMessage = "(veg)";
		}else{
			vegMessage = "(non-veg)";
		}
	}
	/*
	 * Default Constructor 
	 */
	Student(){
		studentName = " ";
		studentLevel = " ";
		veg = false;
		vegMessage = " ";
	}
	
	// Set and get method for studentName, studentLevel, and vegMessage
	public void setStudentName(String n){this.studentName = n;}
	public void setStudentLevel(String l){this.studentLevel = l;}
	public void setVegMessage(boolean vegBool){this.veg = vegBool;}
	public String getStudentName(){return studentName;}
	public String getStudentLevel(){return studentLevel;}
	public boolean getVeg(){return veg;}
	
	//Returns string representation of object student
	public String toString(){
		return "* " + studentName + " - " + studentLevel + vegMessage + "\n";
	}
}
