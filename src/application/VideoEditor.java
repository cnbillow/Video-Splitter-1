package application;

import java.io.File;

public class VideoEditor {

	private File video;
	private double videoLength;
	private double videoIterationLength;
	
	public void splitVideo(){
		
	}
	
	public void saveVideo(){
		
	}
	
	/**
	 * Returns the amount of videos that will be output
	 * @return
	 */
	public int getAmountOfVideosThatWillBeSaved(){
		return (int) (Math.ceil((videoLength/videoIterationLength)));
	}
	
	/**
	 * returns the length of the video
	 * @return
	 */
	public double getVideoLength(){
		return videoLength;
	}
	
	/**
	 * Sets the time length in which the video will be cut
	 * @param videoIterationLength
	 */
	public void setVideoIterationTime(double videoIterationLength){
		this.videoIterationLength = videoIterationLength;
	}
	
	/**
	 * Sets the video we will be currently editing
	 * @param video
	 */
	public void setVideo(File video){
		this.video = video;
	}	
}
