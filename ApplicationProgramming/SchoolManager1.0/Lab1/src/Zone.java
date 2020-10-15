/*
 * Author: Robert Gonzalez 
 * Date: 09/06/2020
 * UTSA Id: Yhs346
 */


/*
 * This class is used to assign zone a zoneName and creates an 
 * array of students in zone
 */
public class Zone {
	String zoneName;
	Student [] studentArr; //create object array
	int i = 0;
	
	/*
	 * Constructor
	 *@param zoneN: zone name
	 *@param s: Number of student in zone
	 */
	Zone(String zoneN,int s){
		this.zoneName = zoneN;
		studentArr = new Student[s];
	}
	
	/*
	 * Default Constructor 
	 * Assigns default values to Zone
	 */
	Zone(){
		zoneName = " ";
		studentArr = new Student[0];
	}
	//Set and get for zoneName in object Zone
	public void setZoneName(String zoneN){
		this.zoneName = zoneN;
	}
	public String getZoneName(){
		return zoneName;
	}
	
	//Set and get for studentArr in object Zone
	public Student[] getStudentArr()
	{
		return studentArr;
	}
	public void setStudentArr(Student[] arr,int sNum){
		for (int x = 0; x < sNum;x++){
			studentArr[x]=arr[x];
			i++;
		}
	}
	/*
	 * Assigns object of class student to studentArr array in postion i
	 */
	public void addStudent(Student s){
		studentArr[i] = s; 
		i++;
	}

	//Returns string representation of object zone
	public String toString(){
		String studentM = "";
		for(int x = 0; x < i; x++){
			studentM = studentM + studentArr[x].toString();
		}
		return zoneName + ": \n" + studentM + "\n";
	}
}
