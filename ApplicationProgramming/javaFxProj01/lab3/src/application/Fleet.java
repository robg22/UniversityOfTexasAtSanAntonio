package application;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The Fleet class creates a new object Fleet and invokes methods to edit 
 * and save Starships and Crew objects
 * 
 * @author Roberto Gonzalez
 * Date: 10/16/2020
 * UTSA Id: Yhs346
 */
public class Fleet {
	private String name;
	public ArrayList<Starship>ships = new ArrayList<>();
	File studentFile,zoneFile;
	
	

	/**
	 * Constructor.
	 * Default constructor assigns values to Fleet
	 */
	Fleet(){
		name = " ";
		
	}
	
	/**
	 * Constructor.
	 * @param name: (String)assigns name
	 * 
	 */
	Fleet(String name){
		this.name = name;
		
	}
	
	/**
	 * Sets Fleet name
	 * @param n String name to set on Fleet
	 */
	public void setName(String n){ 
		this.name = n;
	}
	/**
	 * Returns name of fleet
	 * @return String name of this fleet 
	 */
	public String getName(){
		return name;
	}
	
	
	/**
	 * Returns array list of Starship
	 * @return ArrayList of Starship 
	 */
	public ArrayList<Starship>getShips(){
		return ships;
	}
	/**
	 * Sets the arrayList of fleet of ships
	 * @param ships Starship to be set to this Fleet  
	 */
	public void setShips(ArrayList<Starship>ships){
		this.ships = ships;
	}
	
	/**
	 * Adds a new ship to Array List and does not if it already exists
	 * @param ship1 Starship to be added to this ArrayList of ships
	 */
	public void addShip(Starship ship1){
		if(ships.contains(ship1)){
			System.out.println("Starship already exists");
		}else{
		ships.add(ship1);
		}
	}
	
	/**
	 * @Return toString representation of object Fleet
	 */
	public String toString(){
		String zoneMessage = "";
		
		for(int x = 0; x < ships.size();x++){
			// Creates zoneMessage containing string representation of zoneArr
			
			zoneMessage = zoneMessage + ships.get(x).toString();	
		}
		
		// Returns string representation
		return zoneMessage;
		
	}
	/**
	 * Creates a java file and if file exists it reads lines and creates new ships objects
	 * @param fileName file path to access and create java file (String)
	 */
	
	public void loadStarships(String fileName){
		
		java.io.File file = new java.io.File(fileName);
		zoneFile = file;
		if(file.exists()){
			Scanner input;
			try {
				
				input = new Scanner(file);
				while(input.hasNext()){
					String line = input.nextLine();
					String [] values = line.split(",");
						if(values.length == 3) {
						Starship temp = new Starship(values[0],values[1],values[2]);
						addShip(temp);
						}
					
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	/**
	 * Creates a java file and if file exists reads lines and creates new Crew objects
	 * @param fileName file path to access and create fave file (String)
	 */
	
	public void loadCrewMembers(String fileName){
		
		java.io.File file = new java.io.File(fileName);
		studentFile = file;
		if(file.exists()){
			Scanner input;
			try {
				
				input = new Scanner(file);
				while(input.hasNext()){
				
					String line = input.nextLine();
					
					String [] values = line.split(",");
					
						if(values.length == 5) {
						CrewMember temp = new CrewMember(values[0],values[1],values[2],values[3],values[4]);
						
							for(int i = 0; i < ships.size();i++){
								if(ships.get(i).getRegistry().equals(temp.getRegistry())){
									ships.get(i).addMember(temp);
								}
							}
						}
						
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	public String getStarshipsByName(String s) {
		String starShipArr = "";
		String temp = s;
		
		for(int i = 0;ships.size() > i; i++) {
			String [] values = ships.get(i).getName().toLowerCase().split(" ");
			
			if(values[1].toLowerCase().equals(temp.toLowerCase())) {
				starShipArr = starShipArr + ships.get(i).toString();
				System.out.println(starShipArr);
			}
		}
		
		
		
		
		return starShipArr;
	}
	
	
	}
