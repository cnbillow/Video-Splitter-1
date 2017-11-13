package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Application_Split_Menu_Screen{
	
	@FXML
	Button btnInputFilePath;
	@FXML
	Button btnOutputFilePath;
	@FXML
	TextField tfInputFilePath;
	@FXML
	TextField tfOutputFilePath;
	@FXML
	Slider sVideoInterval;
	@FXML
	Slider sVideoBegining;
	@FXML
	Slider sVideoEnding;
	
	FileManager fileEditor;
	VideoEditor video;
	
	boolean correctVideoFile = false;
	boolean correctOutputPath = false;
	
	public void initialize(){
		fileEditor = new FileManager();
	}
	
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
					//TODO SPLIT VIDEO
					video.setVideo(fileEditor.getFile());
					video.splitVideo();
					video.saveVideo();
				}				
			}
		}
	}
}
