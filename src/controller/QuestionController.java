package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
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
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Question;
import model.SysData;




public class QuestionController implements Initializable {
	
	@FXML 
	TableView<Question> tablee;
	@FXML
	TableColumn<Question,String> question;
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
	@FXML
	Button search1;
	@FXML
	TextField idsearch;
	
	public QuestionController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	 public void search(ActionEvent e)
	 {
		 if(idsearch.getText().equals(""))
		 {
			 Alert a=new Alert(AlertType.CONFIRMATION);
			 a.setHeaderText("Invalid Input!!!");
			 a.showAndWait();
		 }
		 else
		 {
			// Get the word entered in the search text field
			 String searchWord = idsearch.getText().toLowerCase();
			 // Find the first row containing the entered word
			 int index = tablee.getItems().indexOf(tablee.getItems().stream()
			         .filter(question -> question.getQuestionContent().toLowerCase().contains(searchWord))
			         .findFirst()
			         .orElse(null));

			 // If a row containing the word is found, select it in the table and scroll to it
			 if (index >= 0) {
			     tablee.getSelectionModel().select(index);
			     tablee.scrollTo(index);
			 }

			 
		 }
	 }
	
	//fill the table method
  	public void fill() {
  		ObservableList<Question> dataQues = FXCollections.observableArrayList(SysData.getInstance().getAllQuestions());
  		question.setCellValueFactory(new PropertyValueFactory<Question, String>("questionContent"));
  		level.setCellValueFactory(new PropertyValueFactory<Question, String>("level"));
  		correct.setCellValueFactory(new PropertyValueFactory<Question, Integer>("correctAnswerNumber"));
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
	 
	 
	 
	 
	 
	 public void deleteQuestion(ActionEvent event) throws Exception {

			Question q = tablee.getSelectionModel().getSelectedItem();
			if(q == null) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("You have to select Question to delete!");
				alert.show();
			}
			else {
				tablee.getItems().remove(q);
				SysData.getInstance().RemoveFromJson(q);
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setContentText("Deleted Successfully!");
				alert.show();
			}
		}

}
