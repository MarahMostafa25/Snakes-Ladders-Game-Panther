package controller;

import java.io.IOException;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;



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
		Parent roott =FXMLLoader.load(getClass().getResource("/view/LevelView.fxml"));
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

}

	
	

}
