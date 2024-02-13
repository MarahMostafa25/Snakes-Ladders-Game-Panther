package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;




public class MainPageController {
	
	@FXML
	Button startbutton;
	@FXML
	Button historybutton;
	@FXML
	Button questionsbutton;
	@FXML
    AnchorPane root;
	@FXML 
	StackPane stack;
	
	

@FXML
public void start(ActionEvent e) throws IOException {
	
	try {
		Parent roott =FXMLLoader.load(getClass().getResource("/view/levelView.fxml"));
		Scene scene=startbutton.getScene();
		roott.translateXProperty().set(scene.getHeight());
	    StackPane container=(StackPane)scene.getRoot();
	    container.getChildren().add(roott);
		Timeline time=new Timeline();
		KeyValue kv= new KeyValue(roott.translateXProperty(),0,Interpolator.EASE_IN);
		KeyFrame kf=new KeyFrame(Duration.seconds(1),kv);
		time.getKeyFrames().add(kf);
		time.setOnFinished(event1->{
			
			container.getChildren().remove(root);
		});
		time.play();
		
		
		
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
	

}


@FXML
public void history(ActionEvent e) throws IOException {

}


@FXML
public void questions(ActionEvent e) throws IOException {

	
	try {
		Parent root = FXMLLoader.load(getClass().getResource("/view/LogIn.fxml"));
		Scene scene = new Scene(root);
		Main.mainS.setScene(scene);

	} catch (Exception e1) {
		e1.printStackTrace();
	}

}


	

}
