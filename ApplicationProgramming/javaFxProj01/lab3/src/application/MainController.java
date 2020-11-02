package application;

/** @author Robert Gonzalez 
 * Date: 10/16/2020
 * UTSA Id: Yhs346
 * 
 * The MainController classes is used to handle events given by the
 * Main.fxml file.
 */


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
//import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
//import java.io.IOException;

public class MainController implements EventHandler<ActionEvent> {

	@FXML
	Button button1;
	
	@FXML
	TextArea textOutput;
	
	@FXML
	TextField textBox; 
	
	@FXML
	Text text1;
	
	
	@Override
	public void handle(ActionEvent actionEvent) {
		Fleet fleet = new Fleet();
		
		
		fleet.loadStarships("data/fleet.csv");
		
		fleet.loadCrewMembers("data/personnel.csv");
		
		String input =  textBox.getText();
		
		textOutput.setText(fleet.getStarshipsByName(input));
		
		
	}
	
}