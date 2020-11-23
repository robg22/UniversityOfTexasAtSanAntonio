package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Park {
	
	
	Map<String,Zone> zones = new LinkedHashMap<String,Zone>();
	
	ZoneController zone = new ZoneController();
	
	String name; 
	File zFile, dFile;
	
	Park(String name){
		this.name = name;
	} 
	Park(){
		this.name = "";
	}
	
public boolean relocate(Dinosaur d,String n,String current,String cNew) {
	
	
	
	Dinosaur temp = d;
	boolean found = false;
	
		
		if(zones.containsKey(cNew)){
			temp.setCode(cNew);
			found = zones.get(cNew).addStudent2(temp);
			
			if(found) {
				if(zones.containsKey(current)){
				found = zones.get(current).deleteDino(d);	
				}
			} 
			
		}
	
	
	
	return found;
	
}
/**
 * Saves new updated information to files created in earlier methods. If files do not exist
 * the method will not run and give error message.
 * @throws IOException
 */
public void save() throws IOException{
	if(zFile.exists() && dFile.exists()){
		
		try{
			FileWriter write = new FileWriter(dFile);
		
			FileWriter zWrite = new FileWriter(zFile);
		
		
				
		
				Set<String> keys = zones.keySet();
				for(String k:keys) {
				//System.out.println(zones.get(k).getName() + " " + zones.get(k).getSafetyRating() + "  " + zones.get(k).getZoneCode());
				zWrite.append(zones.get(k).getName());
				zWrite.append(",");
				zWrite.append(zones.get(k).getSafetyRating());
				zWrite.append(",");
				zWrite.append(zones.get(k).getZoneCode());
				zWrite.append("\n");
			
				for(int i =0; i <zones.get(k).getDinos().size();i++) {
					
					boolean tempBool = zones.get(k).getDinos().get(i).getCarn();
					
					String tempBoolMessage = "FALSE";
					if(tempBool){tempBoolMessage = "TRUE";}
					
					write.append(zones.get(k).getDinos().get(i).getName()); 
					write.append(",");
					write.append(zones.get(k).getDinos().get(i).getType());
					write.append(",");
					write.append( tempBoolMessage );
					write.append(",");
					write.append(zones.get(k).getDinos().get(i).getCode());
					write.append("\n");
					
				}
				zones.get(k).getDinos().clear();
			}
				zones.clear();
				
				
				
			
			write.flush();
			write.close();
			zWrite.flush();
			zWrite.close();
			
		
		
		
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
public ArrayList<Dinosaur>getMap(String code){
	
	
		
		//Set<String> keys = zones.keySet();
		//for(String k:keys) {
			
			//if(zones.get(k).getZoneCode().equals(code)){
				 
				 return zones.get(code).getDinos();
			//}
		//}
		//return null;
	
		
		
	}
public String setTitle(String code1) {
	
	String titles[] = {"T-Rex Zone (TY)","Brachiosaurus Zone (B)","Dilophosaurus Zone (D)",
			"Gallimimus Zone (G)","Raptor Zone (R)","Reserve Zone (X)",
			"Triceratops Zone (TR)"};
	String titleCode[] = {"TY","B","D","G","R","X","TR"};
	
	for(int i = 0; i< titleCode.length;i++) {
		if(code1.equals(titleCode[i])) {
			return titles[i];
		}
	}
		return null;
	
}
public void loadZones(String fileName){
		
		java.io.File file = new java.io.File(fileName);
		zFile = file;
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
			
		}else {
		System.out.println("Did not exist");
		}
	}

public void addZone(Zone newZone){
	if(zones.containsValue(newZone)){
		System.out.println("Zone already exists");
	}else{
	zones.put(newZone.getZoneCode(),newZone);
	}
}






public void loadDino(String fileName){
		
		java.io.File file = new java.io.File(fileName);
		dFile = file;
		
		if(file.exists()){
			Scanner input;
			try {
				boolean tempBool = false;
				input = new Scanner(file);
				while(input.hasNext()){
					String line = input.next();
					
					String [] values = line.split(",");
					//System.out.println(values.length);
					if(values.length == 4){
						//System.out.println(values[2]);
						if(values[2].charAt(0) == 'T' ||values[2].charAt(0) == 't'){
							tempBool = true;
						}else {
							tempBool = false;
						}
						//System.out.println(values[0] + "====" + values[1]+"===" + values[2] + "==" + values[3]);
						Dinosaur temp = new Dinosaur(values[0],values[1],tempBool,values[3]);
						
						
						zones.entrySet().forEach(entry -> {
							
							//System.out.println(entry.getValue().getName() + "====" + entry.getValue().getZoneCode()+"===" + entry.getValue().getSafetyRating());
							
							if(entry.getValue().getZoneCode().equals(temp.getCode())){
								entry.getValue().addStudent(temp);
							}
						});
							
					}
				}
				
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("File not found");
		}
		
	}

	
	
	
	
	
	
	
	//Loads Zone.fxml and also passes code for use 
	
	public void loadZone(ActionEvent ev,String code) throws IOException {
		Node node = (Node) ev.getSource();
		Stage thisStage = (Stage) node.getScene().getWindow();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Zone.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		
		ZoneController zControl = fxmlLoader.getController();
		
		zControl.setScene(code);
		
		thisStage.setScene(new Scene(root));
		thisStage.show();
	}
	
	public Map<String,Zone> Getzones(){
		return zones;
	}
	
	
	/**
	 * @Return toString representation of object School
	 */
	public String toString(){
		String zoneMessage = "";
		Iterator<Map.Entry<String, Zone>> it = zones.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String,Zone> pair = it.next();
			// Creates zoneMessage containing string representation of zoneArr
			zoneMessage = zoneMessage + pair.getValue().toString();	
		}
		
		// Returns string representation
		return "Welcome to " + name + "\n-----------------------------------\n" + zoneMessage;
		
	}
	
	
	
	
	
	
}
