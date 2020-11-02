package application;

/**
 * The Student class crates student objects to be used in lab2 program
 * 
 * @author Roberto Gonzalez III
 * Date: 10/16/2020
 * UTSA Id: Yhs346
 */

public class CrewMember {
	private String name,position,rank,species,registry;
	
	/**
	 * Constructor 
	 * 
	 * @param name: String Name of student
	 * @param: pos: position of crew member
	 * @param: r: rank of crew member
	 * @param: r2: registry of crew member
	 * @param: s: species of crew member
	 */
	CrewMember(String name, String pos,String r,String r2,String s){
		this.name = name;
		this.position = pos;
		this.rank = r;
		this.species = s;
		this.registry = r2;
		
	}
	
	/**
	 * Default Constructor 
	 */
	CrewMember(){
		name = " ";
		position = " ";
		rank = " ";
		species = " ";
	}
	/**
	 * Sets registry for this crew member
	 * @param r register to set on this crew member (String)
	 */
	public void setRegistry(String r) {this.registry = r;}
	
	/**
	 * Sets crew member name
	 * @param n Name to set on this crew member (String)
	 */
	public void setName(String n){this.name = n;}
	/**
	 * Sets crew member position
	 * @param p position to set on this crew member (String)
	 */
	public void setPosition(String p){this.position = p;}
	
	/**
	 * Sets crew member rank
	 * @param z rank to set on this crew member (String)
	 */
	public void setRank(String z){this.rank = z;}
	
	/**
	 * Sets crew member species
	 * @param s species to set on this crew member (String)
	 */
	
	public void setSpecies(String s){this.species = s;}
	
	/**
	 * Returns registry of crew member
	 * @return String registry of this crew member
	 */
	
	public String getRegistry() {return registry;}
	
	/**
	 * Returns species of crew member
	 * @return String species of this crew member
	 */
	public String getSpecies(){return species;}
	/**
	 * Returns name of crew member
	 * @return String name of this crew member
	 */
	public String getName(){return name;}
	/**
	 * Returns position of crew member
	 * @return String position of this crew member
	 */
	public String getPosition(){return position;}
	
	/**
	 * Returns rank of crew member
	 * @return String rank of this crew member
	 */
	public String getRank(){return rank;}
	
	/**
	 * Returns to toString representation of object crew member

	 */
	
	public String toString(){
		return "	-" + rank + " " + name + ", " + position + " (" + species + ") \n";
	}
	
}

