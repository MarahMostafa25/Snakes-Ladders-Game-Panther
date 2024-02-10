package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.Question;
import model.SysData;
import utils.Level;

public class AddQ implements Initializable{

	
	@FXML
	Button AddQuesion;
	@FXML
	TextField ContentQuestion;
	@FXML
	TextField Answer1;
	@FXML
	TextField Answer2;
	@FXML
	TextField Answer3;
	@FXML
	TextField Answer4;
	@FXML
	Label coerror;
	@FXML
	Label a1;
	@FXML
	Label a2;
	@FXML
	Label a3;
	@FXML
	Label a4;
	@FXML
	ComboBox<Level> correctCombo;
	@FXML
	Button backbutton;
	@FXML
	ComboBox<Integer> correctAnswer;
	
	
	public AddQ() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Level> list=FXCollections.observableArrayList(Level.values());
		correctCombo.setItems(list);
		correctCombo.setVisibleRowCount(5);
		ArrayList<Integer> ar=new ArrayList<Integer>();
		for( int i=1;i<5;i++)
		{
			ar.add(i);
		}
		ObservableList<Integer> list2=FXCollections.observableArrayList(ar);
		correctAnswer.setItems(list2);
		correctAnswer.setVisibleRowCount(5);
		

	}
	
	
	@FXML
	public void keyPressed(KeyEvent e)
	{
		if (e.getSource() == ContentQuestion) {
		    if (!ContentQuestion.getText().chars().anyMatch(Character::isLetter)) {
		        coerror.setText("*with letters!");
		        ContentQuestion.setStyle("-fx-border-color:red;");
		    } else {
		        coerror.setText("");
		        ContentQuestion.setStyle("-fx-border-color:green;");
		    }
		}

		
		if (e.getSource() == Answer1) {
		    if (!Answer1.getText().chars().anyMatch(Character::isLetter)) {
		    	a1.setText("*with letters!");
		        Answer1.setStyle("-fx-border-color:red;");
		    } else {
		    	a1.setText("");
		        Answer1.setStyle("-fx-border-color:green;");
		    }
		}
		
		if (e.getSource() == Answer2) {
		    if (!Answer1.getText().chars().anyMatch(Character::isLetter)) {
		    	a2.setText("*with letters!");
		        Answer2.setStyle("-fx-border-color:red;");
		    } else {
		    	a2.setText("");
		        Answer2.setStyle("-fx-border-color:green;");
		    }
		}
		
		if (e.getSource() == Answer3) {
		    if (!Answer3.getText().chars().anyMatch(Character::isLetter)) {
		    	a3.setText("*with letters!");
		        Answer3.setStyle("-fx-border-color:red;");
		    } else {
		    	a3.setText("");
		        Answer3.setStyle("-fx-border-color:green;");
		    }
		}
		
		if (e.getSource() == Answer4) {
		    if (!Answer4.getText().chars().anyMatch(Character::isLetter)) {
		    	a4.setText("*with letters!");
		        Answer4.setStyle("-fx-border-color:red;");
		    } else {
		    	a4.setText("");
		        Answer4.setStyle("-fx-border-color:green;");
		    }
		}
		
			
		
	}
	
	@FXML
	public void backB(ActionEvent e) throws IOException {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Questions.fxml"));
			Scene scene = new Scene(root);
			Main.mainS.setScene(scene);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	@FXML
	public void add1(ActionEvent e) throws IOException {
		if(ContentQuestion.getText().length() == 0 || Answer1.getText().length() == 0 ||
				Answer2.getText().length() == 0 || Answer3.getText().length() == 0 ||
						Answer4.getText().length() == 0 ) {
		     //if there's one field empty the user gets a note : add is not applied!
			Alert a=new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("FILL ALL FIELDS PLEASE");
			a.showAndWait();
		}
		
		//check if the combo box selected (filled)
		if(correctCombo.getSelectionModel().getSelectedIndex() == -1 || correctAnswer.getSelectionModel().getSelectedIndex() == -1) {
			Alert a=new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("FILL ALL FIELDS PLEASE");
			a.showAndWait();
		}
		
		//get the fields the user filled
		String ques_text = ContentQuestion.getText();
		String ans1_text = Answer1.getText();
		String ans2_text = Answer2.getText();
		String ans3_text = Answer3.getText();
		String ans4_text = Answer4.getText();
		Level levell = correctCombo.getSelectionModel().getSelectedItem();
		int correct=(int) correctAnswer.getSelectionModel().getSelectedItem();
		Question q = new Question(ques_text, levell, 
				ans1_text, ans2_text, ans3_text, ans4_text,correct);
		//write our question to json and add to question hashSet
		SysData.getInstance().writeQuestionToJson(q,"Questions.json");;
		//clear fields
		clearFields();
		Alert a=new Alert(AlertType.CONFIRMATION);
		a.setHeaderText("ADDED SUCCESSFULLY");
		a.showAndWait();

	}
	
	//clear fields
		private void clearFields() {
			ContentQuestion.clear();
			Answer1.clear();
			Answer2.clear();
			Answer3.clear();
			Answer4.clear();
			correctCombo.valueProperty().set(null);
			correctAnswer.valueProperty().set(null);
			
			}

	

}
