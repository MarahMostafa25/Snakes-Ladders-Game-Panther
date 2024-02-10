package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.animation.KeyFrame;

import javafx.scene.media.MediaView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class MovieCont implements Initializable{
	@FXML
	MediaView vm;

	public MovieCont() {
		// TODO Auto-generated constructor stub
	}
	
	//turn on the video.
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	        
		   Media media = new Media(getClass().getResource("/Images/backVid1.mp4").toString());		
		   MediaPlayer player=new MediaPlayer(media);
	       player.setMute(true);
		   player.setCycleCount(MediaPlayer.INDEFINITE);
		   vm.setMediaPlayer(player);
		   player.play();
		   Duration duration = Duration.seconds(4);
	        Timeline timeline = new Timeline(new KeyFrame(duration, event -> {
	        	try {
	    			Parent root = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
	    			Scene scene = new Scene(root);
	    			Main.mainS.setScene(scene);

	    		} catch (Exception e1) {
	    			e1.printStackTrace();
	    		}
	        }));
	        timeline.play();

		
			
		
		
		
	}

}
