package application;

import java.util.prefs.Preferences;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application implements Constants{

	public static void main(String[] args) {
		launch(args);

	}

	/**
	 * rUNS WHEN APPLIACTION IS STARTED
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try{
			Parent root = FXMLLoader.load(getClass().getResource(mainScreenFXML));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(applicationGeneralStyle).toExternalForm());
			Preferences pref = Preferences.userRoot();
			primaryStage.setMinWidth(250.0);
			primaryStage.setMinHeight(200.0);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * rUNS WHEN APPLICATION IS CLOSED
	 */
	@Override
	public void stop(){
		
	}
}
