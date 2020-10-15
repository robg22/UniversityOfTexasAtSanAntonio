package lab2;


/**
 * The Student class crates student objects to be used in lab2 program
 * 
 * @author Roberto Gonzalez III
 * Date: 09/06/2020
 * UTSA Id: Yhs346
 */
public class Student {
	private String studentName,studentLevel,vegMessage,zoneCode;
	boolean veg;
	/**
	 * Constructor 
	 * 
	 * @param name: String Name of student
	 * @param: level:String Grade level of student
	 * @param: vegT: Boolean determining if student is vegetarian
	 */
	Student(String name, String level,boolean vegT,String zoneCode){
		this.studentName = name;
		this.studentLevel = level;
		this.veg = vegT;
		this.zoneCode = zoneCode;
		
		if(vegT){
			vegMessage = "(veg)";
		}else{
			vegMessage = "(non-veg)";
		}
	}
	
	/**
	 * Default Constructor 
	 */
	Student(){
		studentName = " ";
		studentLevel = " ";
		veg = false;
		vegMessage = " ";
		zoneCode = " ";
	}
	
	/**
	 * Sets Student name
	 * @param n Name to set on this student (String)
	 */
	public void setName(String n){this.studentName = n;}
	/**
	 * Set Student level
	 * @param l level to set student to (String)
	 */
	public void setLevel(String l){this.studentLevel = l;}
	/**
	 * Sets veg to true or false and also corrects veg message 
	 * @param vegBool Boolean to set veg to true or false (boolean)
	 */
	public void setVeg(boolean vegBool){
		this.veg = vegBool;
		if(veg){
		this.vegMessage = "(veg)";
		}else{
			this.vegMessage = "(non veg)";
		}
		}
	/**
	 * Sets zoneCode for this student
	 * @param z zoneCode to set on this student
	 */
	public void setZone(String z){this.zoneCode = z;}
	
	
	/**
	 * Returns zoneCode of student
	 * @return String zoneCode of this student
	 */
	public String getZone(){return zoneCode;}
	/**
	 * Return the student name of student
	 * @return String student name of this student
	 */
	public String getName(){return studentName;}
	/**
	 * Returns Student level of student
	 * @return String student level of this student
	 */
	public String getLevel(){return studentLevel;}
	/**
	 * Returns boolean true or false value
	 * @return Boolean true or false of this student
	 */
	public boolean getVeg(){return veg;}
	
	/**
	 * Returns to tostring representation of object student
	 */
	
	public String toString(){
		return "*" + studentName + " - " + studentLevel + vegMessage + "\n";
	}
}
