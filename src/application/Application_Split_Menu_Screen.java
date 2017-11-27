package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Application_Split_Menu_Screen implements Constants{
	
	@FXML
	private Button btnInputFilePath;
	@FXML
	private Button btnOutputFilePath;
	@FXML
	private TextField tfInputFilePath;
	@FXML
	private TextField tfOutputFilePath;
	@FXML 
	private TextField tfIntervalAdding;
	
	private FileManager fileEditor;
	
	private boolean correctVideoFile = false;
	private boolean correctOutputPath = false;
	
	public void initialize(){
		fileEditor = new FileManager();
	}
	
	/**
	 * Handles Button Presses
	 * @param e
	 */
	public void buttonPressed(ActionEvent e){

		String buttonID = ((Button)(e.getSource())).getId();
		
		// Input Button Pressed
		if(buttonID.equals(btnInputFilePath.getId())){
			correctVideoFile = fileEditor.getFile(tfInputFilePath, tfOutputFilePath);
			
			// Output Button Pressed
		}else if(buttonID.equals(btnOutputFilePath.getId())){
			correctOutputPath = fileEditor.getOutputPath(tfOutputFilePath);
			//Split Button Pressed
		}else{
			if(fileEditor.checkTextFields(tfInputFilePath.getText(), tfOutputFilePath.getText()) == true){
				if(correctVideoFile == true && correctOutputPath == true){
					
					Parent loader = null;
					try {
						loader = FXMLLoader.load(getClass().getResource(splitVideoMenuFXML));
					} catch (IOException er) {
						er.printStackTrace();
					}
					Scene scene = new Scene(loader);
					scene.getStylesheets().add(getClass().getResource(applicationGeneralStyle).toExternalForm());
					Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.show();
					
				}				
			}
		}
	}
}
