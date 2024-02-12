package controller;



import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import utils.Level;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class boardController implements Initializable{
	 @FXML
	    private GridPane board;

	    private Pane[][] panes = new Pane[10][10];
	    private int x=10;

	    private final Color[] allowedColors = {
	            Color.web("white"),
	            Color.web("#FDA50F"),
	            
	    };

	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	        // Populate the GridPane with Panes using allowed colors
	        for (int row = 0; row < x; row++) {
	            for (int col = 0; col < x; col++) {
	                Pane pane = createColoredPane(row, col);
	                panes[row][col] = pane;
	                board.add(pane, col, row);
	            }
	        }

	        configureGridPane();
	        
	        
	    }

	    private Pane createColoredPane(int row, int col) {
	        Color color = getRandomColorFromAllowedColors();

	        // Ensure the color is different from neighboring panes
	        while (hasSameColorAsNeighbors(row, col, color)) {
	            color = getRandomColorFromAllowedColors();
	        }

	        Pane pane = new Pane();
	        pane.setStyle("-fx-background-color: " + toHex(color) + ";");
	        pane.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
	        return pane;
	    }

	    private boolean hasSameColorAsNeighbors(int row, int col, Color color) {
	        if (row > 0 && panes[row - 1][col].getStyle().equals("-fx-background-color: " + toHex(color) + ";")) {
	            return true; // Upper neighbor has the same color
	        }
	        if (col > 0 && panes[row][col - 1].getStyle().equals("-fx-background-color: " + toHex(color) + ";")) {
	            return true; // Left neighbor has the same color
	        }
	        return false;
	    }

	    private Color getRandomColorFromAllowedColors() {
	        return allowedColors[(int) (Math.random() * allowedColors.length)];
	    }

	   
	    private void configureGridPane() {
	        // Set constraints to ensure that cells fill the available space without resizing the GridPane
	        for (int i = 0; i < x; i++) {
	            ColumnConstraints colConstraints = new ColumnConstraints();
	            colConstraints.setHgrow(Priority.ALWAYS);
	            colConstraints.setHalignment(HPos.CENTER);
	            board.getColumnConstraints().add(colConstraints);

	            RowConstraints rowConstraints = new RowConstraints();
	            rowConstraints.setVgrow(Priority.ALWAYS);
	            rowConstraints.setValignment(VPos.CENTER);
	            board.getRowConstraints().add(rowConstraints);
	        }

	        // Set the preferred size of each pane
	        double cellWidth = board.getPrefWidth() / x;
	        double cellHeight = board.getPrefHeight() / x;

	        for (int row = 0; row < x; row++) {
	            for (int col = 0; col < x; col++) {
	                panes[row][col].setPrefSize(cellWidth, cellHeight);
	            }
	        }
	    }

	    private String toHex(Color color) {
	        return String.format("#%02X%02X%02X",
	                (int) (color.getRed() * 255),
	                (int) (color.getGreen() * 255),
	                (int) (color.getBlue() * 255));
	    }
	}