package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.RulesClickedObserver;

public class RuleController implements RulesClickedObserver {
	 public static MediaPlayer media1;
	@FXML
	Button backbutton;
	@FXML
	Button muteButton;
	public RuleController() {
		// TODO Auto-generated constructor stub
		try {
			Main.media.setVolume(0.3);
			media1=new MediaPlayer(new Media(getClass().getResource("/Images/story.mp3").toString()));
			media1.setCycleCount(1);
			media1.play();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	//go  to to the main page
		@FXML
		public void backB(ActionEvent e) throws Throwable {
			try {
				RuleController.media1.stop();
				Main.media.setVolume(1);
				Parent root = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
				Scene scene = new Scene(root);
				Main.mainS.setScene(scene);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		@Override
		public void onRulesClicked() {
			// TODO Auto-generated method stub
			 System.out.println("Rules button clicked!");
		}
		@FXML
		private void handleMuteButtonAction(ActionEvent event) {
			Main.toggleMusic();
		}

}
