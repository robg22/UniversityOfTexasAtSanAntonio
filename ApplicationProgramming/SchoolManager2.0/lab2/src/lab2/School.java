package lab2;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The School class creates a new object School and invokes methods to edit 
 * and save zones and Student objects
 * 
 * @author Roberto Gonzalez
 * Date: 09/06/2020
 * UTSA Id: Yhs346
 */
public class School {
	private String schoolName;
	public ArrayList<Zone>zones = new ArrayList<>();
	File studentFile,zoneFile;
	
	

	/**
	 * Constructor.
	 * Default constructor assigns values to schoolName
	 * and creates array
	 */
	School(){
		schoolName = " ";
		//zoneArr = new Zone[20];
	}
	
	/**
	 * Constructor.
	 * @param name: (String)assigns schoolName
	 * 
	 */
	School(String name){
		this.schoolName = name;
		
	}
	
	/**
	 * Sets School name
	 * @param n String name to set on School
	 */
	public void setName(String n){ 
		this.schoolName = n;
	}
	/**
	 * Returns name of school
	 * @return String name of this School 
	 */
	public String getName(){
		return schoolName;
	}
	
	/**
	 * Returns array list of zones 
	 * @return ArrayList of zones 
	 */
	public ArrayList<Zone>getZones(){
		return zones;
	}
	/**
	 * Sets the arrayList of zones of School
	 * @param zones Zones to be set to this School  
	 */
	public void setZones(ArrayList<Zone>zones){
		this.zones = zones;
	}
	
	/**
	 * Adds a new Zone to Array List and does not if it already exists
	 * @param newZone Zone to be added to this ArrayList of zones
	 */
	public void addZone(Zone newZone){
		if(zones.contains(newZone)){
			System.out.println("Zone already exists");
		}else{
		zones.add(newZone);
		}
	}
	
	/**
	 * @Return toString representation of object School
	 */
	public String toString(){
		String zoneMessage = "";
		for(int x = 0; x < zones.size();x++){
			// Creates zoneMessage containing string representation of zoneArr
			zoneMessage = zoneMessage + zones.get(x).toString();	
		}
		
		// Returns string representation
		return "Welcome to " + schoolName + "\n-----------------------------------\n" + zoneMessage;
		
	}
	/**
	 * Creates a java file and if file exists it reads lines and creates new zone objects
	 * @param fileName file path to access and create java file (String)
	 */
	
	public void loadZones(String fileName){
		
		java.io.File file = new java.io.File(fileName);
		zoneFile = file;
		if(file.exists()){
			Scanner input;
			try {
				input = new Scanner(file);
				while(input.hasNext()){
					String line = input.next();
					String [] values = line.split(",");
					if(values.length == 3){
						Zone temp = new Zone(values[0],values[1],values[2]);
						addZone(temp);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	/**
	 * Creates a java file and if file exists reads lines and creates new student objects
	 * @param fileName file path to access and create fave file (String)
	 */
	
	public void loadStudents(String fileName){
		
		java.io.File file = new java.io.File(fileName);
		studentFile = file;
		if(file.exists()){
			Scanner input;
			try {
				boolean tempVeg = false;
				input = new Scanner(file);
				while(input.hasNext()){
					String line = input.next();
					String [] values = line.split(",");
					if(values.length == 4){
						
						if(values[2].toUpperCase().equals("TRUE")){
							tempVeg = true;
						}else
							tempVeg = false;
					}
						Student temp = new Student(values[0],values[1],tempVeg,values[3]);
						for(int i = 0; i < zones.size();i++){
							if(zones.get(i).getZoneCode().equals(temp.getZone())){
								zones.get(i).addStudent(temp);
							}
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * Takes in a name and code and relocates Student object who has given and name and relocates
	 * student to given code name. Does not execute of name or code does not exist.
	 * @param name Student name used to locate student object (String)
	 * @param code Zone code name used to located zone object (String)
	 */
	public void relocate(String name, String code){
		boolean zoneFound = false;
		boolean sFound = false;
		int zoneIndex = 0;
		
		for(int i = 0; i < zones.size();i++){
			if(zones.get(i).getZoneCode().equals(code)){
				zoneFound = true;
				zoneIndex = i;
			}
		}
		
		if(zoneFound){
			for(int i = 0; i < zones.size() && !sFound;i++){
				for(int x = 0; x  < zones.get(i).getStudents().size() && !sFound;x++){
					if(zones.get(i).getStudents().get(x).getName().equals(name)){
						Student temp = new Student(name,zones.get(i).getStudents().get(x).getLevel(),zones.get(i).getStudents().get(x).getVeg(),code);
						zones.get(i).removeStudent(zones.get(i).getStudents().get(x)); 
						zones.get(zoneIndex).addStudent(temp);
						sFound = true;
					}
					}
				}
				if(!sFound){
					System.out.println("ERROR: Zone " + code + " was found but student " + name + " was not!");
				}
				
		}else{
			System.out.println("Zone was not found");
		}
			
	}
	
	/**
	 * Saves new updated information to files created in earlier methods. If files do not exist
	 * the method will not run and give error message.
	 * @throws IOException
	 */
	public void save() throws IOException{
		if(studentFile.exists() && zoneFile.exists()){
			
			try{
				FileWriter write = new FileWriter(studentFile);
			
			FileWriter zWrite = new FileWriter(zoneFile);
			
			
				for(int i = 0 ; i < zones.size();i++){
				
					zWrite.append(zones.get(i).getName());
					zWrite.append(",");
					zWrite.append(zones.get(i).getSafetyRating());
					zWrite.append(",");
					zWrite.append(zones.get(i).getZoneCode());
					zWrite.append("\n");
				
					for(int x = 0; x < zones.get(i).getStudents().size();x++){
						boolean tempBool = zones.get(i).getStudents().get(x).getVeg();
						String tempBoolMessage = "FALSE";
						if(tempBool){tempBoolMessage = "TRUE";}
						
						write.append(zones.get(i).getStudents().get(x).getName()); 
						write.append(",");
						write.append(zones.get(i).getStudents().get(x).getLevel());
						write.append(",");
						write.append( tempBoolMessage );
						write.append(",");
						write.append(zones.get(i).getStudents().get(x).getZone() );
						write.append("\n");
										
					}
					
				}
				write.flush();
				write.close();
				zWrite.flush();
				zWrite.close();
				
				
			
			
		}catch (IOException e){
			e.printStackTrace();
			
		}
		
	}else System.out.println("File does note exist!");
	
	

	
	}}
