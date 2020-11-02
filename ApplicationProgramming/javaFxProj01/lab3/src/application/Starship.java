package application;


import java.util.ArrayList;


 
/** @author Robert Gonzalez 
 * Date: 10/16/2020
 * UTSA Id: Yhs346
 * 
 * The Starship class is used to create Starship objects and creates an 
 * arrayList of CrewMember objects to be stored in this class
 */

/**
 * @author yhs346
 *
 */

public class Starship {
	
	private String name, registry, Sclass;
	
	private ArrayList<CrewMember>cMember  = new ArrayList<>();
	
	
	/**
	 * Constructor
	 *@param n: name to set Starship name for this Starship
	 *@param r: to set registry for this Starship
	 *@param sc: to set Sclass for this Starship
	 */
	

	
	Starship(String n,String r,String sc){
		this.name = n;
		this.registry = r;
		this.Sclass = sc;
		
	}
	
	/**
	 * Default Constructor 
	 * Assigns default values to Starship
	 */
	Starship(){
		name = " ";
		registry = " ";
		Sclass = " ";
	}
	
	
	/**
	 * Sets the Name of Starship
	 * @param n Name to set on this Starship (String)
	 */
	public void setName(String n){
		this.name = n;
	}
	/**
	 * Returns the Starship name of Starship
	 * @return name of this Starship (String)
	 */
	public String getName(){
		return name;
	}
	
	
	/**
	 * Sets the registry of Starship
	 * @param r registry to be set on this Starship
	 */
	public void setRegistry(String r){
		this.registry = r;
	}
	/**
	 * Returns registry of Starship
	 * @return registry of this Starship (String)
	 */
	public String getRegistry(){
		return registry; 
	}
	
	/**
	 * Sets starshipClass for starship
	 * @param c Sclass to be set for this starship
	 */
	
	public void setStarshipClass(String c){
		this.Sclass = c;
	}
	/**
	 * Returns Sclass
	 * @return Sclass of this starship (String)
	 */
	public String getStarshipClass(){
		return Sclass; 
	}
	
	
	/**
	 * Returns ArrayList of Crew member in starship
	 * @return cMember ArrayList in this starship (ArrayList)
	 */
	public ArrayList<CrewMember>getMembers()
	{
		return cMember;
	}
	/**
	 * Sets the ArrayList of cMember in starship
	 * @param cMember CrewMember ArrayList to set on this starship (ArrayList)
	 */
	public void setStudents(ArrayList<CrewMember>members){
		this.cMember = members; 
	}
	
	
	/**
	 * Removes crew from arrayList of CrewMember in starship
	 * @param s is cMember object to be removed (object)
	 */
	public void removeMember(CrewMember s){
		if(cMember.contains(s)){
			cMember.remove(s);
		}else{
			System.out.println("ERROR: Object does not exist");
		}
	}
	
	/**
	 * adds member to ArrayList of cMembers in zone
	 * @param s CrewMember object to be added to ArrayList of CrewMembers (ArrayList)
	 */
	
	public void addMember(CrewMember s){
		if(cMember.contains(s)){
			System.out.println("ERROR: Object already exists");
		}else{
			cMember.add(s);
		}
	}

	/**
	 * Returns toString method of object Starship
	 */
	public String toString(){
		String memberA = "";
		for(int x = 0; x < cMember.size(); x++){
			memberA = memberA + cMember.get(x).toString();
		}
		return name + " [" + registry + "], Class: " + Sclass + ", Crew: " + cMember.size() + " \n" + memberA + "\n";
	}
}
