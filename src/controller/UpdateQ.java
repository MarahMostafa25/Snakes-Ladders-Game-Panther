package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Question;
import utils.Level;


public class UpdateQ {

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


	
	public UpdateQ() {
		// TODO Auto-generated constructor stub
	}

}
