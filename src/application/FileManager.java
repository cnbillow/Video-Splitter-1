package application;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.scene.control.TextField;

public class FileManager {

	private File currentFile;
	private String outputDirectory;
	private String extention = "mp4";
	
	/**
	 * uses the file chooser to get a file, the user will be prompted to chose an mp4 file
	 * but if the user choses a different format file it will warn the user that that format is not 
	 * currently compatible with the user
	 * @param tfInputFilePath - the text field so i can add the absolute directory path for the user
	 * @param tfOutputFilePath - the text field so i can fill it in for the user
	 * @return
	 */
	public boolean getFile(TextField tfInputFilePath, TextField tfOutputFilePath){

		JFileChooser chooser = new JFileChooser();
		
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"MP4 Videos", "MP4");			
			chooser.setFileFilter(filter);
			chooser.showOpenDialog(null);
			
			if(checkFileFormat(chooser.getSelectedFile(), extention) == true){
				tfInputFilePath.setText( chooser.getSelectedFile().getAbsolutePath());
				tfOutputFilePath.setText(chooser.getSelectedFile().getAbsolutePath().substring(0, 
						chooser.getSelectedFile().getAbsolutePath().length() - chooser.getSelectedFile().getName().length()));
				currentFile = chooser.getSelectedFile();
				return true;
			}else{
				tfInputFilePath.setText("");
				tfOutputFilePath.setText("");
				currentFile = null;
				return false;
			}
	}
	
	/**
	 * Uses File Explorer to get a driectory to where the videos will be saved
	 * @param tfOutputFilePath - the directory that is going to be the output directory
	 * @return boolean depending if the directory is available or not
	 */
	public boolean getOutputPath(TextField tfOutputFilePath){
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.showOpenDialog(null);
		outputDirectory = chooser.getSelectedFile().getAbsolutePath();
		if(checkIfItsADirectory(outputDirectory) == true){
			tfOutputFilePath.setText(outputDirectory +  System.getProperty("file.separator"));			
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Check if the file is in the correct format
	 * @param file - file being checked
	 * @param extention - extentions that are acceptable
	 * @return - boolean that tells program if it is a correct file or note
	 */
	public boolean checkFileFormat(File file, String extention){
	    String ext = null;
        String fileName = file.getName();
        int i = fileName.lastIndexOf('.');

        if (i > 0 &&  i < fileName.length() - 1) {
            ext = fileName.substring(i+1).toLowerCase();
        }
        
	    if (ext != null) {
	        if (ext.equals("mp4")) {
	                return true;
	        } else {
	        	JOptionPane.showConfirmDialog(null, "File is not in mp4 format. Please select a different file.");
	            return false;
	        }
	    }
		JOptionPane.showConfirmDialog(null, "No file was selected.");
		return false;
	}
	
	/**
	 * Checks if the directory exist and if not creates it TODO CREATE DIRECTORY IF IT DOESNT EXIST
	 * @param filePath - directory we are checking
	 * @return boolean representing if the file is available or not
	 */
	public boolean checkIfItsADirectory(String filePath){
		File file = new File(filePath);
		if(file.isDirectory()){
			return true;
		}else{
			JOptionPane.showConfirmDialog(null, "This is not a proper directory.");
			return false;
		}
	}
	
	/**
	 * Does one alst check on the textfield incase the user has changed something
	 * @param pathToFile - the absolute path to the file they ahve selected
	 * @param pathtoOutputPath - the output path to which the files will be saved at
	 * @return boolean depening on whether they both are okay or one is wrong
	 */
	public boolean checkTextFields(String pathToFile, String pathtoOutputPath){
		File file = new File(pathToFile);
		if((checkFileFormat(file, extention) == true) && (checkIfItsADirectory(pathtoOutputPath) ==  true)){
			return true;			
		}else{
			return false;
		}
	}
	
	/**
	 * returns current selected path
	 * @return
	 */
	public File getFile(){
		return currentFile;
	}
	
	/**
	 * returns currently outputPath
	 * @return
	 */
	public String getOutputPath(){
		return outputDirectory;
	}
}
