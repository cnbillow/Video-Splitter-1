package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Application_Split_Menu_Screen implements Constants{
	
	@FXML
	private Button btnInputFilePath;
	@FXML
	private Button btnOutputFilePath;
	@FXML
	private Button btnSubmitInfo;
	@FXML
	private Button btnStartSplittingAndSaving;
	@FXML
	private TextField tfInputFilePath;
	@FXML
	private TextField tfOutputFilePath;
	@FXML 
	private TextField tfIntervalAdding;
	
	private FileManager fileEditor;
	
	private boolean correctVideoFile = false;
	private boolean correctOutputPath = false;
	private boolean submitButtonPressed = false;
	
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
		}else if(buttonID.equals(btnSubmitInfo.getId())){
			if(submitButtonPressed == false){
				btnInputFilePath.setDisable(true);
				btnOutputFilePath.setDisable(true);
				tfInputFilePath.setDisable(true);
				tfOutputFilePath.setDisable(true);
				tfIntervalAdding.setDisable(true);
				btnStartSplittingAndSaving.setDisable(false);
				btnSubmitInfo.setText("Undo");
				submitButtonPressed = true;
			}else{
				btnInputFilePath.setDisable(!true);
				btnOutputFilePath.setDisable(!true);
				tfInputFilePath.setDisable(!true);
				tfOutputFilePath.setDisable(!true);
				tfIntervalAdding.setDisable(!true);
				btnStartSplittingAndSaving.setDisable(!false);
				btnSubmitInfo.setText("Submit");
				submitButtonPressed = false;
			}
		}else{
			if(fileEditor.checkTextFields(tfInputFilePath.getText(), tfOutputFilePath.getText()) == true){
				if(correctVideoFile == true && correctOutputPath == true){
					VideEditor ve = new VideoEditor();
				}				
			}
		}
	}
}
