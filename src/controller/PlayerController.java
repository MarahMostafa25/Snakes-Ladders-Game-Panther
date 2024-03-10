package controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import model.HelpClass;
import model.InputValidator;
import model.NoNumbersValidation;
import model.NonEmptyValidation;
import model.Player;
import utils.Level;

public class PlayerController {
	@FXML
	Button add;
	@FXML
	Button del;
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
    private int isFirstTimeClickedDel =1;
    private int numPlayer=2;
	
    
    //add player
	@FXML
	public void addPLayer(ActionEvent e) throws IOException {
		if(isFirstTimeClicked==1)
		{
			Image newImage = new Image("/Images/egyy3.png");

			image3.setImage(newImage);
			image31.setImage(newImage);

	        name3.setStyle("-fx-background-color: white;");
	        isFirstTimeClicked=2;
	        isFirstTimeClickedDel=1;
	        numPlayer++;

			
		}
		else
		{
			if(isFirstTimeClicked==2)
			{
				Image newImage2 = new Image("/Images/egyy4.png");

				image4.setImage(newImage2);
				image41.setImage(newImage2);

		        name4.setStyle("-fx-background-color: white;");
		        isFirstTimeClicked=3;
		        isFirstTimeClickedDel=2;
		        numPlayer++;

				
			}
		}
		

	}
	
	//get back to previous page
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
	
	
	
	
	
	
	
	
	//remove players 
	@FXML
	public void delPLayer(ActionEvent e) throws IOException {
		if(isFirstTimeClickedDel==1)
		{
			
     
			image3.setImage(null);
			image31.setImage(null);
			name3.setText("");
			name3.setStyle("-fx-background-color: transparent;");
	        isFirstTimeClicked=1;
	        isFirstTimeClickedDel=0;
	        numPlayer--;

			
		}
		else
		{
			if(isFirstTimeClickedDel==2)
			{
				

				image4.setImage(null);
				image41.setImage(null);
				name4.setText("");
				name4.setStyle("-fx-background-color: transparent;");
		        isFirstTimeClicked=2;
		        isFirstTimeClickedDel=1;
		        numPlayer--;
		        

				
			}
		}
		

	}
	//here i saved the players in the helping class instance so i could use it in the real game
	@FXML
	public void start2(ActionEvent e) throws IOException {
		Set<String> uniquePlayers = new HashSet<>();
		HelpClass.getInstance().setNumOfPlayer(numPlayer);
		String navigate="";
		if(HelpClass.getInstance().getLevelGame().equals(Level.Easy))
		{
			navigate="/view/EasyBoard.fxml";
		}
		if(HelpClass.getInstance().getLevelGame().equals(Level.Medium))
		{
			navigate="/view/board.fxml";
		}
		if(HelpClass.getInstance().getLevelGame().equals(Level.Hard))
		{
			navigate="/view/HardBoard.fxml";
		}
		InputValidator nameValidator = new InputValidator(new NoNumbersValidation());
		InputValidator emptyValidator = new InputValidator(new NonEmptyValidation());
	    boolean inputsValid = true;
	    boolean inputsValid2 = true;
		if(numPlayer==2) {
			uniquePlayers.add(name1.getText());
			uniquePlayers.add(name2.getText());
			if(uniquePlayers.size()!=2) {
				Alert a=new Alert(AlertType.CONFIRMATION);
				a.setHeaderText("names are unique");
				a.showAndWait();
				return;
				}
            inputsValid = nameValidator.validateInput(name1.getText()) && nameValidator.validateInput(name2.getText());
            inputsValid2 = emptyValidator.validateInput(name1.getText()) && emptyValidator.validateInput(name2.getText());

            if(!inputsValid||!inputsValid2)
            {

				Alert a=new Alert(AlertType.CONFIRMATION);
				a.setHeaderText("Choose character names please");
				a.showAndWait();
            }
			else
			{
				Player p1=new Player(name1.getText(),1,"Images/egy1.png");
				Player p2=new Player(name2.getText(),1,"Images/egyy2.png");
				HelpClass.getInstance().setP1(p1);
				HelpClass.getInstance().setP2(p2);
				
				//here navigate to other screen
				try {
					Parent root = FXMLLoader.load(getClass().getResource(navigate));
					Scene scene = new Scene(root);
					Main.mainS.setScene(scene);

				} catch (Exception e1) {
					e1.printStackTrace();
				}


			}
		}
		else
		{
			if(numPlayer==3)
			{
				uniquePlayers.add(name1.getText());
				uniquePlayers.add(name2.getText());
				uniquePlayers.add(name3.getText());
				if(uniquePlayers.size()!=3) {
					Alert a=new Alert(AlertType.CONFIRMATION);
					a.setHeaderText("names are unique");
					a.showAndWait();
					return;
					}
	            inputsValid = nameValidator.validateInput(name1.getText()) && nameValidator.validateInput(name2.getText()) && nameValidator.validateInput(name3.getText());
	            inputsValid2 = emptyValidator.validateInput(name1.getText()) && emptyValidator.validateInput(name2.getText()) && emptyValidator.validateInput(name3.getText());

	            if(!inputsValid||!inputsValid2)
	            {

					Alert a=new Alert(AlertType.CONFIRMATION);
					a.setHeaderText("Choose character names please");
					a.showAndWait();
	            }
				
				else
				{
					Player p1=new Player(name1.getText(),1,"Images/egy1.png");
					Player p2=new Player(name2.getText(),1,"Images/egyy2.png");
					Player p3=new Player(name3.getText(),1,"Images/egyy3.png");

					HelpClass.getInstance().setP1(p1);
					HelpClass.getInstance().setP2(p2);
					HelpClass.getInstance().setP3(p3);
					
					//navigate
					try {
						Parent root = FXMLLoader.load(getClass().getResource(navigate));
						Scene scene = new Scene(root);
						Main.mainS.setScene(scene);

					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			}
			else
			{
				if(numPlayer==4)
				{
					uniquePlayers.add(name1.getText());
					uniquePlayers.add(name2.getText());
					uniquePlayers.add(name3.getText());
					uniquePlayers.add(name4.getText());
					if(uniquePlayers.size()!=4) {
						Alert a=new Alert(AlertType.CONFIRMATION);
						a.setHeaderText("names are unique");
						a.showAndWait();
						return;
						}
		            inputsValid = nameValidator.validateInput(name1.getText()) && nameValidator.validateInput(name2.getText()) && nameValidator.validateInput(name3.getText()) && nameValidator.validateInput(name4.getText());
		            inputsValid2 = emptyValidator.validateInput(name1.getText()) && emptyValidator.validateInput(name2.getText()) && emptyValidator.validateInput(name3.getText()) && emptyValidator.validateInput(name4.getText());

		            if(!inputsValid||!inputsValid2)
		            {

						Alert a=new Alert(AlertType.CONFIRMATION);
						a.setHeaderText("Choose character names please");
						a.showAndWait();
		            }
					else
					{
						Player p1=new Player(name1.getText(),1,"Images/egy1.png");
						Player p2=new Player(name2.getText(),1,"Images/egyy2.png");
						Player p3=new Player(name3.getText(),1,"Images/egyy3.png");
						Player p4=new Player(name4.getText(),1,"Images/egyy4.png");

						HelpClass.getInstance().setP1(p1);
						HelpClass.getInstance().setP2(p2);
						HelpClass.getInstance().setP3(p3);
						HelpClass.getInstance().setP4(p4);
						try {
							Parent root = FXMLLoader.load(getClass().getResource(navigate));
							Scene scene = new Scene(root);
							Main.mainS.setScene(scene);

						} catch (Exception e1) {
							e1.printStackTrace();
						}
						

					}
				}
			}
		}
		
		
				
		
	}

}
