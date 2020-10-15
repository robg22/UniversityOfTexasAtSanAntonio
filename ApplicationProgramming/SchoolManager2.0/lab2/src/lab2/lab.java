package lab2;

import java.io.IOException;

/*
 * Author: Robert Gonzalez
 * UTSA Id: Yhs346
 * Date: 09/07/2020
 * 
 * Lab1 is a program developed for an elementary school to help keep track of the zones/areas within
 * the school, and the students in each zone.
 * 
 */
/**
 * @author Robert Gonzalez III
 * Utsa Id: Yhs346
 * Date: 09/28/2020
 * 
 * Lab2 is a java class containing a main method to run your program when completed.
 * This class will not compile until you have completed the requirements outlined.
 * Description: Lab2 is a program developed for an elementary school to help keep track of the 
 * zones/areas within the school, and the students in each zone
 *
 */
public class lab {

	public static void main(String[] args) throws IOException{
		/**
		 * Creates new object of School called m
		 */
		School m = new School("Monroe_May_Elemn_School");
		
		
		/**
		 * Load zones.csv from specified file path
		 */
		m.loadZones( "data/zones.csv" ); 
		/**
		 * Load students.csv from specified file path
		 */
		m.loadStudents("data/students.csv");
		
		/**
		 * Prints toSting method before relocate
		 */
		System.out.println(m);
		
		/**
		 * Relocates student blue into zone TY
		 */
		m.relocate("Blue","TY");
		
		/**
		 * Saves updated csv for students and zones back into specified file path
		 */
		m.save();
		
		System.out.println(m);
		
	}

}

