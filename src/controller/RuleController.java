package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class RuleController {

	@FXML
	Button backbutton;
	public RuleController() {
		// TODO Auto-generated constructor stub
	}
	//get back to previous page
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

}
