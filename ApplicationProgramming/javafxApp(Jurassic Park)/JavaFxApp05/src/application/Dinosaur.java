package application;
/**
 * The Student class crates student objects to be used in lab2 program
 * 
 * @author Roberto Gonzalez III
 * Date: 09/06/2020
 * UTSA Id: Yhs346
 */

public class Dinosaur {
	

		private String name,type,code,carnM;
		boolean carn;
		/**
		 * Constructor 
		 * 
		 * @param name: String Name of student
		 * @param: level:String Grade level of student
		 * @param: vegT: Boolean determining if student is vegetarian
		 */
		Dinosaur(String name, String type,boolean carn,String code){
			this.name = name;
			this.type = type;
			this.carn = carn;
			this.code = code;
			if(this.carn){
				carnM = "carnivore";
			}else {
				carnM = "(NOT) carnivore";
			}
		}
		
		/**
		 * Default Constructor 
		 */
		Dinosaur(){
			name = " ";
			type = " ";
			carn = false;
			
		}
		
		/**
		 * Sets Student name
		 * @param n Name to set on this student (String)
		 */
		public void setName(String n){this.name = n;}
		/**
		 * Set Student level
		 * @param l level to set student to (String)
		 */
		public void setType(String l){this.type = l;}
		/**
		 * Sets veg to true or false and also corrects veg message 
		 * @param vegBool Boolean to set veg to true or false (boolean)
		 */
		public void setCarn(boolean carn){
			this.carn  = carn;
			}
		public void setCode(String code){
			this.code  = code;
			}
		

		/**
		 * Returns zoneCode of student
		 * @return String zoneCode of this student
		 */
		public String getType(){return type;}
		/**
		 * Return the student name of student
		 * @return String student name of this student
		 */
		public String getName(){return name;}
		/**
		 * Return the student name of student
		 * @return String student name of this student
		 */
		public String getCode(){return code;}
		
		/**
		 * Returns boolean true or false value
		 * @return Boolean true or false of this student
		 */
		public boolean getCarn(){return carn;}
		
		
		/**
		 * Returns to tostring representation of object student
		 */
		
		public String toString(){
			return name + " - " + type + "-" + carnM + "\n";
		}
	

}
