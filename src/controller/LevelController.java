package controller;

import java.io.IOException;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import model.HelpClass;
import utils.Level;

public class LevelController {
	
	@FXML
	Button easy;
	@FXML
	Button medium;
	@FXML
	Button hard;
	@FXML
    AnchorPane root;
	
	@FXML
	Button conti;
	@FXML
	Button backbutton;
	
	private Level levell;

	public LevelController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	public void contiPlayer(ActionEvent e) throws IOException {
		if(levell != null) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/view/Players.fxml"));
			Scene scene = new Scene(root);
			Main.mainS.setScene(scene);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		}
		else
		{
			Alert a=new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("Choose Level Please");
			a.showAndWait();
		}
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
	
	@FXML
	public void levalTo(ActionEvent e) throws IOException {
		if(e.getSource()==easy)
		{
			levell=Level.Easy;
		}
		if(e.getSource()==medium)
		{
			levell=Level.Medium;
		}
		if(e.getSource()==hard)
		{
			levell=Level.Hard;
			
		}
		HelpClass.getInstance().setLevelGame(levell);
	}

}
