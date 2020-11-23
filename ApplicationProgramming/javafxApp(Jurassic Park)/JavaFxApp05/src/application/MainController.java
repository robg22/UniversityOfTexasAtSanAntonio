package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class MainController {
	Park park = new Park();
	
	@FXML
	private Button B;
	@FXML
	private Button D;
	@FXML
	private Button G;
	@FXML
	private Button R;
	@FXML
	private Button TR;
	@FXML
	private Button Ty;
	@FXML
	private Button X;
	
	@FXML
	public void Bclicked(ActionEvent event) throws IOException{
		Button b = (Button) event.getSource();
		String text = b.getText();
		
		park.loadZone(event,text);
		
		
	}
	public void initialize() {
		B.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		D.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		G.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		R.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		TR.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		Ty.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		X.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
	
	}
	
	
	
	

}
