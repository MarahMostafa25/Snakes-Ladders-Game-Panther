package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.ResourceBundle;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Question;
import model.SysData;
import view.MainMenu;



public class QuestionController implements Initializable {
	
	@FXML 
	TableView<Question> tablee;
	@FXML
	TableColumn<Question,String> question;
	@FXML
	TableColumn<Question,String> ans1 ;
	@FXML
	TableColumn<Question,String> ans2;
	@FXML
	TableColumn<Question,String> ans3;
	@FXML
	TableColumn<Question,String> ans4;
	@FXML
	TableColumn<Question,Integer> correct;
	@FXML
    TableColumn<Question, String> level;

	
	@FXML
    Button add;
	@FXML
    Button remove;
	@FXML
    Button update;
	@FXML
    Button backbutton;
	
	public QuestionController() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	//fill the table method
  	public void fill() {
  		ObservableList<Question> dataQues = FXCollections.observableArrayList(SysData.getInstance().getAllQuestions());
  		question.setCellValueFactory(new PropertyValueFactory<Question, String>("questionContent"));
  		level.setCellValueFactory(new PropertyValueFactory<Question, String>("level"));
  		correct.setCellValueFactory(new PropertyValueFactory<Question, Integer>("correctAnswerNumber"));
  		ans1.setCellValueFactory(new PropertyValueFactory<Question, String>("answer1"));
  		ans2.setCellValueFactory(new PropertyValueFactory<Question, String>("answer2"));
  		ans3.setCellValueFactory(new PropertyValueFactory<Question, String>("answer3"));
  		ans4.setCellValueFactory(new PropertyValueFactory<Question, String>("answer4"));
  		HashSet<Question> set = new HashSet<>();
  		set.addAll(dataQues);
  		ObservableList<Question>dataQues2 =  FXCollections.observableArrayList(set);
  		tablee.setItems(dataQues2);
  	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SysData.getInstance().loadQ("Questions.json");;
		fill();
		tablee.refresh();
		
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
	public void addQ(ActionEvent e) throws IOException {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/AddQuesion1.fxml"));
			Scene scene = new Scene(root);
			Main.mainS.setScene(scene);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	 @FXML
	   public boolean UpdateScene(ActionEvent event) {
	    	try {
	    		if(tablee.getSelectionModel().getSelectedIndex() == -1) {
	    			Alert a=new Alert(AlertType.CONFIRMATION);
	    			a.setHeaderText("FILL ALL FIELDS PLEASE");
	    			a.showAndWait();
	    			return false;
	    		}
	    		//question to update is question selected
	    		UpdateQ.questionT = tablee.getSelectionModel().getSelectedItem();
				Parent root = FXMLLoader.load(getClass().getResource("/view/UpdateQuesion.fxml"));
				Scene scene = new Scene(root);
				Main.mainS.setScene(scene);
				return true;

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return true;
	    }

}
