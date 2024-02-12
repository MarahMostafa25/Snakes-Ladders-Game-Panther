package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class ManagerLogIn implements Initializable{

	@FXML
	MediaView vm;
	@FXML
    AnchorPane root;
	@FXML
	Button backbutton;
	@FXML
	Button con;
	@FXML
	TextField id;
	@FXML
	TextField pass;
	
	public ManagerLogIn() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		  Media media = new Media(getClass().getResource("/Images/manageranimation.mp4").toString());		
		   MediaPlayer player=new MediaPlayer(media);
		   player.setCycleCount(MediaPlayer.INDEFINITE);
		   vm.setMediaPlayer(player);
		   player.play();
		   
		    Duration duration = Duration.seconds(4);
	        Timeline timeline = new Timeline(new KeyFrame(duration, event -> {
	            player.stop();
	        }));
	        timeline.setCycleCount(1);
	        timeline.play();

		
	}
	
	@FXML
	public void backB(ActionEvent e) throws IOException {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
			Scene scene = new Scene(root);
			Main.mainS.setScene(scene);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
	//make sure that the input is right
	@FXML
	public void goQ(ActionEvent e) throws IOException {
		if(id.getText().length()==0||pass.getText().length()==0)
		{
			Alert a=new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("Fill PLease");
			a.showAndWait();
		}
		else
		{
			if(id.getText().equals("manager")&&pass.getText().equals("manager"))
			{
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/view/Questions.fxml"));
					Scene scene = new Scene(root);
					Main.mainS.setScene(scene);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else
			{
				Alert a=new Alert(AlertType.CONFIRMATION);
				a.setHeaderText("Only Manger can enter this page");
				a.showAndWait();
			}
		}
		
				
				
	}
	

}
