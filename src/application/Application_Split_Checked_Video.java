package application;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;

public class Application_Split_Checked_Video {

	@FXML
	Slider sVideoInterval;
	@FXML
	Slider sVideoBegining;
	@FXML
	Slider sVideoEnding;
	
	VideoEditor video;
	
	public void initialize(){
		video = new VideoEditor();
		setSliderInfo();
	}

	public void startSplittingVideo(){
		//TODO SPLIT VIDEO
		//video.setVideo();
		video.splitVideo();
		video.saveVideo();
	}
	
	private void setSliderInfo(){
		
	}
}
