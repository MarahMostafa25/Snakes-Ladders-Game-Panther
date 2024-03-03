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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Game;
import model.Player;
import utils.Level;

public class GameHisController implements Initializable{

	
	
	@FXML 
	TableView<Game> table;
	@FXML
	TableColumn<Game,Integer> gameNum;
	@FXML
	TableColumn<Game,Level> level;
	@FXML
	TableColumn<Game,Player> winner;
	@FXML
	TableColumn<Game,String> time;
	@FXML
    Button backbutton;
	
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
	
	public GameHisController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Main.deSerialize();
		ArrayList<Game> all_games=new ArrayList<Game>();
		all_games.addAll(Main.res.getAllgames());
		ObservableList<Game> dataGame = FXCollections.observableArrayList(all_games);
		gameNum.setCellValueFactory(new PropertyValueFactory<Game,Integer>("gameNum"));
		level.setCellValueFactory(new PropertyValueFactory<Game,Level>("gameLevel"));
		winner.setCellValueFactory(new PropertyValueFactory<Game,Player>("winner"));
		time.setCellValueFactory(new PropertyValueFactory<Game,String>("gameTimer"));
		
		table.setItems(dataGame);	
	}

}
