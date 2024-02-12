package controller;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import utils.Level;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class boardController implements Initializable{
	@FXML
	GridPane board;
	@FXML
	Button backbutton;
	 @FXML
	    private Rectangle boardBackground;
	 @FXML
	    private GridPane cells;
	//public void addCells(Level level)
	//{
		//if (level == Level.Easy) {
			
			
	//	}
       //  if (level == Level.Medium) {
			
			
		//}
     //    if()
	//}
	 public void init() {
	        for (int row = 0; row < 13; row++) {
	            for (int column = 0; column < 13; column++) {
	                TextField box = new TextField();
	                box.setEditable(false);
	                String style = (row + column) % 2 == 1 ? "-fx-background-color: black" : "-fx-background-color: white";
	                box.setStyle(style);
	                board.add(box, column, row);
	        }
	        }
	 }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	//@Override
	/*public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// Set the gap between cells (optional)
		board.setHgap(5);
		board.setVgap(5);

        // Populate the GridPane with rectangles (you can replace Rectangle with other nodes)
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Rectangle rectangle = new Rectangle(50, 50, Color.LIGHTBLUE);
                board.add(rectangle, col, row);
            }
        }
	}*/
}
