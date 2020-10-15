package lab2;

import java.util.ArrayList;


 
/** @author Robert Gonzalez 
 * Date: 09/06/2020
 * UTSA Id: Yhs346
 * 
 * The Zone class is used to create zone objects and creates an 
 * arrayList of Student object to be stored in this class
 */

/**
 * @author yhs346
 *
 */
public class Zone {
	private String zoneName, safetyRating, zoneCode;
	private ArrayList<Student>students  = new ArrayList<>();
	
	
	/**
	 * Constructor
	 *@param zoneN: zone name to set zone name for this Zone
	 *@param safetyRating to set safety rating for this Zone
	 *@param code to set code for this Zone
	 */
	

	
	Zone(String zoneN,String safetyRating,String code){
		this.zoneName = zoneN;
		this.safetyRating = safetyRating;
		this.zoneCode = code;
		
	}
	
	/**
	 * Default Constructor 
	 * Assigns default values to Zone
	 */
	Zone(){
		zoneName = " ";
		safetyRating = " ";
		zoneCode = " ";
	}
	
	
	/**
	 * Sets the zone Name of zone
	 * @param zoneN Name to set on this Zone (String)
	 */
	public void setName(String zoneN){
		this.zoneName = zoneN;
	}
	/**
	 * Returns the zone name of zone
	 * @return zoneName of this zone (String)
	 */
	public String getName(){
		return zoneName;
	}
	
	
	/**
	 * Sets the safety rating of zone
	 * @param r safety rating to be set on this zone
	 */
	public void setSafetyRating(String r){
		this.safetyRating = r;
	}
	/**
	 * Returns safety Rating of Zone
	 * @return safetyRating of this Zone (String)
	 */
	public String getSafetyRating(){
		return safetyRating; 
	}
	
	/**
	 * Sets zone code for zone
	 * @param c zoneCode to be set for this ZOne
	 */
	
	public void setZoneCode(String c){
		this.zoneCode = c;
	}
	/**
	 * Returns zoneCode
	 * @return zoneCode of this zone (String)
	 */
	public String getZoneCode(){
		return zoneCode; 
	}
	
	/**
	 * Returns ArrayList of students in zone
	 * @return students ArrayList in this zone (ArrayList)
	 */
	public ArrayList<Student>getStudents()
	{
		return students;
	}
	/**
	 * Sets the ArrayList of students in zone
	 * @param students students ArrayList to set on this zone (ArrayList)
	 */
	public void setStudents(ArrayList<Student>students){
		this.students = students; 
	}
	
	
	/**
	 * Removes student from arrayList of students in zone
	 * @param s is student object to be removed (object)
	 */
	public void removeStudent(Student s){
		if(students.contains(s)){
			students.remove(s);
		}else{
			System.out.println("ERROR: Object does not exist");
		}
	}
	
	/**
	 * adds Student to ArrayList of students in zone
	 * @param s Student object to be added to ArrayList of student (ArrayList)
	 */
	
	public void addStudent(Student s){
		if(students.contains(s)){
			System.out.println("ERROR: Object already exists");
		}else{
			students.add(s);
		}
	}

	/**
	 * Returns toString method of object Zone
	 */
	public String toString(){
		String studentM = "";
		for(int x = 0; x < students.size(); x++){
			studentM = studentM + students.get(x).toString();
		}
		return zoneCode + ":" + zoneName + "(" + safetyRating + ") \n" + studentM + "\n";
	}
}
