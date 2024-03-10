package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.json.simple.parser.ParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import model.Question;
import model.SysData;
import utils.Level;


public class UpdateQ  implements Initializable{

	public static Question questionT = null;
    @FXML
    private TextField question_text;

    @FXML
    private TextField answer1_text;

    @FXML
    private TextField answer2_text;

    @FXML
    private TextField answer3_text;

    @FXML
    private TextField answer4_text;

    @FXML
    private ComboBox<Integer> correct;
    @FXML
    private ComboBox<Level> level;

    @FXML
    private Button updateButton;
    @FXML
    private Button backbutton;
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


	
	public UpdateQ() {
		// TODO Auto-generated constructor stub
	}

	public void updateQuestion(ActionEvent e) throws IOException, ParseException {
		Set<String> uniqueAnswers = new HashSet<>();
		if(question_text.getText().length() == 0 || answer1_text.getText().length() == 0 ||
				answer2_text.getText().length() == 0 || answer3_text.getText().length() == 0 ||
						answer4_text.getText().length() == 0 ) {
		     //if there's one field empty the user gets a note : add is not applied!
			Alert a=new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("FILL ALL FIELDS PLEASE");
			a.showAndWait();
			return;
		}
		uniqueAnswers.clear();  // Clear the set before checking again
	    uniqueAnswers.add(answer1_text.getText());
	    uniqueAnswers.add(answer2_text.getText());
	    uniqueAnswers.add(answer3_text.getText());
	    uniqueAnswers.add(answer4_text.getText());
	    if(uniqueAnswers.size() != 4)
	    {
	    	Alert a=new Alert(AlertType.CONFIRMATION);
			a.setHeaderText("un unique answers");
			a.showAndWait();
			return;
	    }
		else {
		
			//check if the combo box selected (filled)
			if(!question_text.getText().chars().anyMatch(Character::isLetter)||!answer1_text.getText().chars().anyMatch(Character::isLetter)||!answer2_text.getText().chars().anyMatch(Character::isLetter)||!answer3_text.getText().chars().anyMatch(Character::isLetter)||!answer4_text.getText().chars().anyMatch(Character::isLetter)||correct.getSelectionModel().getSelectedIndex() == -1 || correct.getSelectionModel().getSelectedIndex() == -1) {
				Alert a=new Alert(AlertType.CONFIRMATION);
				a.setHeaderText("INVALID");
				a.showAndWait();
			}
			else {
			
				//get the fields the user filled
				String ques_text = question_text.getText();
				String ans1_text = answer1_text.getText();
				String ans2_text = answer2_text.getText();
				String ans3_text = answer3_text.getText();
				String ans4_text = answer4_text.getText();
				Level levell = level.getSelectionModel().getSelectedItem();
				int correct4= (int) correct.getSelectionModel().getSelectedItem();
				Question q = new Question(ques_text, levell, 
						ans1_text, ans2_text, ans3_text, ans4_text,correct4);
				SysData.getInstance().RemoveFromJson(questionT);
		    	SysData.getInstance().writeQuestionToJson(q,"Questions.json");;
				//clear fields
				clearFields();
				Alert a=new Alert(AlertType.CONFIRMATION);
				a.setHeaderText("ADDED SUCCESSFULLY");
				a.showAndWait();
			}
		}

	}
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// TODO Auto-generated method stub
		ObservableList<Level> list=FXCollections.observableArrayList(Level.values());
		level.setItems(list);
		level.setVisibleRowCount(5);
		ArrayList<Integer> ar=new ArrayList<Integer>();
		for( int i=1;i<5;i++)
		{
			ar.add(i);
		}
		ObservableList<Integer> list2=FXCollections.observableArrayList(ar);
		correct.setItems(list2);
		correct.setVisibleRowCount(5);
		question_text.setText(questionT.getQuestionContent());
		answer1_text.setText(questionT.getAnswer1());
		answer2_text.setText(questionT.getAnswer2());
		answer3_text.setText(questionT.getAnswer3());
		answer4_text.setText(questionT.getAnswer4());
		level.setValue(questionT.getLevel());
		correct.setValue(questionT.getCorrectAnswerNumber());
		
		
		
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
	
	//clear all fields
	private void clearFields() {
		question_text.clear();
		answer1_text.clear();
		answer2_text.clear();
		answer3_text.clear();
		answer4_text.clear();
		correct.valueProperty().set(null);
		level.valueProperty().set(null);
		
		}
	
	
	
	//i used this method to make sure that the player will input something which make sense (not only numbers)
	@FXML
	public void keyPressed(KeyEvent e)
	{
		if (e.getSource() == question_text) {
		    if (!question_text.getText().chars().anyMatch(Character::isLetter)) {
		        coerror.setText("*with letters !");
		        question_text.setStyle("-fx-border-color:red;");
		    } else {
		        coerror.setText("");
		        question_text.setStyle("-fx-border-color:green;");
		    }
		}

		
		if (e.getSource() == answer1_text) {
		    if (!answer1_text.getText().chars().anyMatch(Character::isLetter)) {
		    	a1.setText("*with letters!");
		    	answer1_text.setStyle("-fx-border-color:red;");
		    } else {
		    	a1.setText("");
		    	answer1_text.setStyle("-fx-border-color:green;");
		    }
		}
		
		if (e.getSource() == answer2_text) {
		    if (!answer2_text.getText().chars().anyMatch(Character::isLetter)) {
		    	a2.setText("*with letters!");
		    	answer2_text.setStyle("-fx-border-color:red;");
		    } else {
		    	a2.setText("");
		    	answer2_text.setStyle("-fx-border-color:green;");
		    }
		}
		
		if (e.getSource() == answer3_text) {
		    if (!answer3_text.getText().chars().anyMatch(Character::isLetter)) {
		    	a3.setText("*with letters!");
		    	answer3_text.setStyle("-fx-border-color:red;");
		    } else {
		    	a3.setText("");
		    	answer3_text.setStyle("-fx-border-color:green;");
		    }
		}
		
		if (e.getSource() == answer4_text) {
		    if (!answer4_text.getText().chars().anyMatch(Character::isLetter)) {
		    	a4.setText("*with letters!");
		    	answer4_text.setStyle("-fx-border-color:red;");
		    } else {
		    	a4.setText("");
		    	answer4_text.setStyle("-fx-border-color:green;");
		    }
		}
		
			
		
	}
	

}
