package application;

import java.util.*;

public class Zone {
	private String zoneName, safetyRating, zoneCode;
	
	//Map<Integer,Dinosaur> dinoMap = new LinkedHashMap<Integer,Dinosaur>();
	
	private ArrayList<Dinosaur>dinoMap  = new ArrayList<>();
	
	
	
	/**
	 * Constructor
	 *@param zoneN: zone name to set zone name for this Zone
	 *@param safetyRating to set safety rating for this Zone
	 *@param code to set code for this Zone
	 */
	

	public void clearDino() {
		dinoMap.clear();
	}
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
	public ArrayList<Dinosaur>getDinos()
	{
		return dinoMap;
	}
	/**
	 * Sets the ArrayList of students in zone
	 * @param students students ArrayList to set on this zone (ArrayList)
	 */
	public void setStudents(ArrayList<Dinosaur>dino){
		this.dinoMap = dino; 
	}
	
	
	/**
	 * Removes student from arrayList of students in zone
	 * @param s is student object to be removed (object)
	 */
	public boolean deleteDino(Dinosaur s){
		if(dinoMap.contains(s)){
			dinoMap.remove(s);
			return true;
		}else{
			System.out.println("ERROR: Object does not exist");
			return false;
		}
	}
	
	/**
	 * adds Student to ArrayList of students in zone
	 * @param s Student object to be added to ArrayList of student (ArrayList)
	 */
	
	public void addStudent(Dinosaur s){
		if(dinoMap.contains(s)){
			System.out.println("ERROR: Object already exists");
		}else{
			dinoMap.add(s);
		
		}
	}
	public boolean addStudent2(Dinosaur s){
		if(dinoMap.contains(s)){
			System.out.println("ERROR: Object already exists");
			return false;
		}else{
			dinoMap.add(s);
			
			return true;
		}
	}
	


	/**
	 * Returns toString method of object Zone
	 */
	
	
	
	public String toString(){
		String studentM = "";
		for(int i=0;i<dinoMap.size();i++) {
			
			studentM = studentM +dinoMap.get(i).toString();
		}
		
		return zoneCode + ":" + zoneName + "(" + safetyRating + ") \n" + studentM + "\n";
	}
}
