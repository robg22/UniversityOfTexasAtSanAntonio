/*
 * Author: Robert Gonzalez 
 * Date: 09/06/2020
 * UTSA Id: Yhs346
 */




/*
 * This class is used to assign a school name to object school and creates an array
 * of zone objects
 */
public class School {
	String schoolName;
	
	int i = 0; 
	
	Zone [] zoneArr; 
	/*
	 * Constructor.
	 * Default constructor assigns values to schoolName
	 * and creates array
	 */
	School(){
		schoolName = " ";
		zoneArr = new Zone[20];
	}
	
	/*
	 * Constructor.
	 * @param name: assigns schoolName
	 * @param zones: allocates memory for zoneArr
	 */
	School(String name,int zones){
		this.schoolName = name;
		zoneArr = new Zone[zones];
	}
	// Set and get function for schoolName in object School
	public void schoolName(String n){ 
		this.schoolName = n;
	}
	public String getSchoolName(){
		return schoolName;
	}
	
	// Set and get for zoneArr inside object School
	public Zone[] getZoneArr()
	{
		return zoneArr;
	}
	public void setZoneArr(Zone[] arr,int sNum){
		for (int x = 0; x < sNum;x++){
			zoneArr[x]=arr[x];
			i++;
		}
	}
	/*
	 * Assigns object newZone to position i in zoneArr array
	 */
	public void addZone(Zone newZone){
		zoneArr[i] = newZone;
		i++;
	}
	
	/*
	 * Returns string representation of object School
	 */
	public String toString(){
		String zoneMessage = "";
		for(int x = 0; x < i;x++){
			// Creates zoneMessage containing string representation of zoneArr
			zoneMessage = zoneMessage + zoneArr[x].toString();	
		}
		
		// Returns string representation
		return "Welcome to " + schoolName + "\n-----------------------------------\n" + zoneMessage;
		
	}
	
}
