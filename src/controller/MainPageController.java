package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import model.RulesClickedObserver;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;




public class MainPageController implements Initializable{

	@FXML
	Button startbutton;
	@FXML
	Button historybutton;
	@FXML
	Button questionsbutton;
	@FXML
	Button rules;
	@FXML
	AnchorPane root;
	@FXML 
	StackPane stack;
	private List<RulesClickedObserver> rulesClickedObservers = new ArrayList<>();
	 public RuleController ruleController;
	 
	  public MainPageController() {
	        ruleController = new RuleController(); // Initialize the RuleController
	        addRulesClickedObserver(ruleController); // Register RuleController as an observer
	    }

	@FXML
	public void rules(ActionEvent e) throws IOException {
        notifyRulesClickedObservers();

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/GameRules.fxml"));
			Scene scene = new Scene(root);
			Main.mainS.setScene(scene);

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
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
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/GameHistory.fxml"));
			Scene scene = new Scene(root);
			Main.mainS.setScene(scene);

		} catch (Exception e1) {
			e1.printStackTrace();
		}


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
	
	 public void addRulesClickedObserver(RulesClickedObserver observer) {
	        rulesClickedObservers.add(observer);
	    }

	    public void removeRulesClickedObserver(RulesClickedObserver observer) {
	        rulesClickedObservers.remove(observer);
	    }
	    
	    private void notifyRulesClickedObservers() {
	        for (RulesClickedObserver observer : rulesClickedObservers) {
	            observer.onRulesClicked();
	        }
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			Main.media.play();
			
		}




}
