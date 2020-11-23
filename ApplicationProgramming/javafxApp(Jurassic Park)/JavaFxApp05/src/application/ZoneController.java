package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ZoneController {
	@FXML
	private Button goBack;
	@FXML
	private Button add;
	@FXML
	private Button relocate;
	
	
	
	@FXML
	private Label title;
	@FXML
	private Label dinoCount;
	@FXML
	private Label riskLevel;
	@FXML
	private Label sucessLevel;
	
	
	@FXML
	private TextField addName;
	@FXML
	private TextField addType;
	@FXML
	private TextField rName;
	@FXML
	private TextField rCode;
	@FXML
	private RadioButton yes;
	@FXML
	private RadioButton no;
	
	@FXML
	private ListView<String> dinoList;
	
	ArrayList<Dinosaur> dinoMap;
	
	Park park1; 
	String globalCode = "";
	
	public void handleBack(ActionEvent event) throws IOException {
		
		Node node = (Node) event.getSource();
		Stage thisStage = (Stage) node.getScene().getWindow();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		thisStage.setScene(new Scene(root));
		thisStage.show();
				
		
	}
	@FXML
	public void addNew(ActionEvent event) throws IOException {
		String name = addName.getText();
		String type = addType.getText();
		boolean completed = true;
		boolean temp = false;
		
			if(!name.equals("") && !type.equals("")){
				//System.out.println(name);
				for(int i = 0; i<park1.getMap(globalCode).size() && completed == true ;i++) {
					//System.out.println(park1.getMap(globalCode).get(i).getName() +" -----" + name);
					if(park1.getMap(globalCode).get(i).getName().equals(name)) {
						completed = false;
					}
				}
				if(!completed) {
					sucessLevel.setText("Error " + name + " Already Exists In This Section" );
				}
				
			}else {
				completed = false;
				sucessLevel.setText("Invalid Input!");
			}
			
			if(no.isSelected()) {
				temp = false;
				System.out.println("NO");
			}else if(yes.isSelected()) {
				temp = true;
				System.out.println("YES");
			}else {
				if(completed) {
				sucessLevel.setText("You must select yes or no");
				completed = false;
				}
			}
			
			if(completed) {
				Dinosaur temp1 = new Dinosaur(name,type,temp,globalCode);
				park1.getMap(globalCode).add(temp1);
				sucessLevel.setText("Sucessfully added: " + name);
				park1.save();
				setNewList(globalCode);
			}
		
			
	}
	
	@FXML
	public void relocate(ActionEvent event) throws IOException {
		String name = rName.getText();
		String zCode = rCode.getText();
		boolean completed = false;
	
		
		
			for(int i = 0; i<park1.getMap(globalCode).size() && completed == false ;i++) {
			if(park1.getMap(globalCode).get(i).getName().equals(name)){
				completed = park1.relocate(park1.getMap(globalCode).get(i),name,globalCode,zCode);
			}
			
				 
			
		}
		if(completed) {
			sucessLevel.setText("Successfully Updated!");
			
			park1.save();
			setNewList(globalCode);
			System.out.println(park1);
		}else {
			sucessLevel.setText("Error: Dino does not exist or check input");
			
		}
		
	}
	
	public void setNewList(String c) {
		park1.loadZones("data/zones.csv");
		park1.loadDino("data/dinos.csv");
		
		dinoList.getItems().clear();
		//dinoList.getItems().add("Helloooo");
		
		//dinoMap.clear();
		dinoMap = park1.getMap(globalCode);
		int count = 0;
		if(dinoMap != null) {
		for(int i = 0; i < dinoMap.size();i++) {
				count++;
			
				dinoList.getItems().add(dinoMap.get(i).toString());
			}
			}
		dinoCount.setText("" + count);
			
	}
	
	
	public void setScene(String c) {
		
		globalCode = c;
		
		Park park = new Park("Jurassic Park");
		park1 = park;
		
		park1.loadZones("data/zones.csv");
		park1.loadDino("data/dinos.csv");
		dinoMap = park1.getMap(c);
		
		int count = 0;
		if(dinoMap != null) {
			title.setText(park1.setTitle(c));
			for(int i = 0; i < dinoMap.size();i++) {
				count++;
				
				dinoList.getItems().add(dinoMap.get(i).toString());
				
			}
			
		}
		Map<String,Zone> zones = park1.Getzones();
		
		dinoCount.setText("" + count);
		goBack.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		add.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		relocate.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		
		ToggleGroup group = new ToggleGroup();
		yes.setToggleGroup(group);
		no.setToggleGroup(group);
		riskLevel.setText(zones.get(globalCode).getSafetyRating());
		
		//Ggroup = group;
		
		
	}
	
	public void initialize() {
		
		
	
		
		
	
	}
	
	
	
}
