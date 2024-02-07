package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class PlayerController {
	@FXML
	Button add;
	@FXML
	Button startButton;
	@FXML
	Button questionsbutton;
	@FXML
    AnchorPane root;
	@FXML 
	StackPane stackk;
	@FXML
	TextField name1;
	@FXML
	TextField name2;
	@FXML
	TextField name3;
	@FXML
	TextField name4;
	@FXML
	ImageView image3;
	@FXML
	ImageView image4;
	@FXML
	ImageView image41;
	@FXML
	ImageView image31;
	
	@FXML
	Button backbutton;
	
    private int isFirstTimeClicked =1;

	
	@FXML
	public void addPLayer(ActionEvent e) throws IOException {
		if(isFirstTimeClicked==1)
		{
			Image newImage = new Image("/Images/image3.png");

			image3.setImage(newImage);
			image31.setImage(newImage);

	        name3.setStyle("-fx-text-fill: white;");
	        isFirstTimeClicked=2;

			
		}
		else
		{
			if(isFirstTimeClicked==2)
			{
				Image newImage2 = new Image("/Images/image4.png");

				image4.setImage(newImage2);
				image41.setImage(newImage2);

		        name4.setStyle("-fx-text-fill: white;");
		        isFirstTimeClicked=3;

				
			}
		}
		

	}
	
	@FXML
	public void backB(ActionEvent e) throws IOException {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/LevelView.fxml"));
			Scene scene = new Scene(root);
			Main.mainS.setScene(scene);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	

	
	
	
	

	public PlayerController() {
		// TODO Auto-generated constructor stub
	}

}
