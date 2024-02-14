package controller;



import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import utils.Level;
import utils.SnakeColor;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Ladder;
import model.Snake;
import javafx.scene.image.Image;



public class boardController implements Initializable{
	@FXML
	private GridPane board;
	private int x=10;
	private Pane[][] panes = new Pane[x][x];
	private  Label label;
	// This hashmap saves what the user see
	private HashMap<Integer,HashMap<Integer,Integer>> boardCells= new HashMap<Integer, HashMap<Integer, Integer>>();
	private HashMap<Integer,Snake> snakesOnBoard = new HashMap<Integer,Snake>();
	private HashMap<Integer,Ladder> laddersOnBoard = new HashMap<Integer,Ladder>();
	private HashMap<Integer,Boolean> ocuupiedCells = new HashMap<Integer,Boolean>();
	
	
	//60,205
    private ImageView gr1 = new ImageView(new Image("/Images/greenSnake.png"));
    private ImageView gr2 = new ImageView(new Image("/Images/greenSnake.png"));
    //35,200
    private ImageView bl = new ImageView(new Image("/Images/blueSnake.png"));
    //170,96
    private ImageView yellow = new ImageView(new Image("/Images/yellowSnake.png"));
    private ImageView red1 = new ImageView(new Image("/Images/redSnake.png"));
    private ImageView red2 = new ImageView(new Image("/Images/redSnake.png"));
    /*ladders*/
    
    //ladder1 , 55,100 
    //ladder2 , 39,135
    //ladder3, 61,187
    //ladder4,87,237
    //ladder5,87,283
    //ladder6 103,350
    private ImageView ladder1 = new ImageView(new Image("/Images/ladder1.png"));
    private ImageView ladder2 = new ImageView(new Image("/Images/ladder2.png"));
    private ImageView ladder3= new ImageView(new Image("/Images/ladder3.png"));
    private ImageView ladder4 = new ImageView(new Image("/Images/ladder41.png"));
    private ImageView ladder41 = new ImageView(new Image("/Images/ladder41.png"));
    private ImageView ladder6 = new ImageView(new Image("/Images/ladder6.png"));
    
	private void initializeOccupiedCells(int x) {
	    for (int i = 1; i <= x*x; i++) {
	    	ocuupiedCells.put(i, false);
	    }
	}
	// a way to go from row and col to actual value.
	private int calLabelValue(int row,int col)
	{
		int labelValue;
		if (row % 2 == 0) {
			labelValue = ((x - row) * x - col);
		} else {
			labelValue = ((x - row) * x - (x - col - 1));
		}
		return labelValue;
	}


	// This function converts the row and cols to the numbers on the board 
	private void setBoardCells(int x) // shows the user board the number of each cell
	{
		for (int row = 0; row < x; row++) {
			for (int col = 0; col < x; col++) {
				int labelValue;
				labelValue = calLabelValue(row, col);
				HashMap<Integer, Integer> rowColPair = new HashMap<>();
				rowColPair.put(row, col);
				boardCells.put(labelValue, rowColPair);
			}
		}
	}
	private final Color[] allowedColors = {
			Color.web("white"),
			Color.web("#FDA50F"),
	};
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Populate the GridPane with Panes using allowed colors
		int rows = x;
		int cols = x;
		initializeOccupiedCells(x);
		setBoardCells(x);
	//	System.out.println(ocuupiedCells.get(50));
		startBoard(rows,cols,x); //This function starts the board and number the cells
		setSquare();
		setSnakes();
		// setSnakes();
		configureGridPane(); // This function colors the board
		

		// fillSnakes();


	}
	public void startBoard(int rows, int cols, int x) { //finished
		for (int row = 0; row < x; row++) {
			for (int col = 0; col < x; col++) {
				Pane pane = createColoredPane(row, col);
				int labelValue;
				labelValue = calLabelValue(row, col);
				// Add label with labelValue text to the pane
				Label label = new Label("" + labelValue);
				// Set alignment to center
				label.setAlignment(Pos.CENTER);
				// Make the label bold
				label.setStyle("-fx-font-weight: bold;");
				pane.getChildren().add(label);
				panes[row][col] = pane;
				board.add(pane, col, row);
			}
		}
	}
	public int setObjCheckOcuupied()
	{
		Random random = new Random();
		int randomRow = random.nextInt(x-1);
		int randomCol = random.nextInt(x-1);
		int labelValue = calLabelValue(randomRow, randomCol);
		 while(ocuupiedCells.get(labelValue))
			{
				randomRow = random.nextInt(x-1);
				randomCol = random.nextInt(x-1);
				labelValue = calLabelValue(randomRow, randomCol);
			}
		 ocuupiedCells.put(labelValue, true);
		 return labelValue;
	}
	public void setSquare() // sets surprise and question
	{
		int labelValue = setObjCheckOcuupied();
		while(labelValue > ((x*x)-10)) // can't jump over the end 
			labelValue = setObjCheckOcuupied();
		ocuupiedCells.put(labelValue, true);
		ImageView surprise = new ImageView(new Image("/Images/surprise.png"));
		surprise.setFitWidth(40);
		surprise.setFitHeight(40);
		HashMap<Integer , Integer > map =  boardCells.get(labelValue); 
		int row=0;
		int col=0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
             row = entry.getKey();
             col = entry.getValue();
        }
		GridPane.setConstraints(surprise, col, row,1,1);//first is column , second is row,
		board.getChildren().add(surprise);
	for(int i=0;i<3;i++)
	{
		 labelValue = setObjCheckOcuupied();
		 ocuupiedCells.put(labelValue, true);
		ImageView question = new ImageView(new Image("/Images/question.jpg"));
		question.setFitWidth(40);
		question.setFitHeight(40);
		//Set constraints to span 2 columns and 1 row
		//first is column , second is row,
	 map =  boardCells.get(labelValue); 
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
             row = entry.getKey();
             col = entry.getValue();
        }
		GridPane.setConstraints(question, col, row,1,1);
		board.getChildren().add(question);
	}
	}
	public void setSnakes()
	{
		Snake snake = null;
		int labelValue = 0;
		/*********first Kind red snakes  *********/
		for(int i=0;i<2;i++) {
		labelValue = setObjCheckOcuupied();
		while((labelValue == x*x) ||(labelValue == 1)) // Can't be at the end or the start
			labelValue = setObjCheckOcuupied();
		 snake = new Snake(labelValue,labelValue,SnakeColor.red);
		 ocuupiedCells.put(labelValue, true);
		 snakesOnBoard.put(labelValue, snake);
		 HashMap<Integer , Integer > map =  boardCells.get(labelValue); 
			int row=0;
			int col=0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	             row = entry.getKey();
	             col = entry.getValue();
	        }
			if(i == 0)
		 setSnakeToBoardView(red1,40,40,row,col);
			if (i==1)
				setSnakeToBoardView(red2,40,40,row,col);
		}
		/**************** second kind is blue snake  ***************/
		labelValue = setObjCheckOcuupied();
		while((labelValue == x*x) || (labelValue < 31)) // Can't be at the end or the start
			labelValue = setObjCheckOcuupied();
		HashMap<Integer , Integer > map =  boardCells.get(labelValue); 
		int row = 0;
		int col = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
             row = entry.getKey();
             col = entry.getValue();
        }
		int endValue = calLabelValue(row+3, col);
		 snake = new Snake(labelValue,endValue,SnakeColor.blue);
		 ocuupiedCells.put(labelValue, true);
		 snakesOnBoard.put(labelValue, snake);
		 setSnakeToBoardView(bl,35,200,row,col);
		 /****************yellow Snake *******************/ 
		 labelValue = setObjCheckOcuupied();
		 map =  boardCells.get(labelValue);
		 row = 0;
		 col = 0;
		 for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	           row = entry.getKey();
	           col = entry.getValue();
	        }
			while((labelValue == x*x) || (labelValue < 13)||col==x-1||col==x-2) // Can't be at the end or the start
				labelValue = setObjCheckOcuupied();
			
			 endValue = calLabelValue(row+1, col+2);
			 snake = new Snake(labelValue,endValue,SnakeColor.blue);
			 ocuupiedCells.put(labelValue, true);
			 snakesOnBoard.put(labelValue, snake);
			 setSnakeToBoardView(yellow,170,96,row,col);
			 /************Green Snake**************************/
				for(int i=0;i<2;i++) {
					labelValue = setObjCheckOcuupied();
					while((labelValue == x*x) ||(labelValue < 30)) // Can't be at the end or the start
						labelValue = setObjCheckOcuupied();
					 map =  boardCells.get(labelValue); 
					 row=0;
					 col=0;
					for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			             row = entry.getKey();
			             col = entry.getValue();
			        }
					 endValue = calLabelValue(row+2, col);
					 snake = new Snake(labelValue,labelValue,SnakeColor.red);
					 ocuupiedCells.put(labelValue, true);
					 snakesOnBoard.put(labelValue, snake);
						if(i == 0)
					 setSnakeToBoardView(gr1,60,205,row,col);
						if (i==1)
							setSnakeToBoardView(gr2,60,205,row,col);
				}
	}
	public void setSnakeToBoardView(ImageView image,int w,int h,int row,int col) {
		image.setFitWidth(w);
		image.setFitHeight(h);
		image.setPreserveRatio(true);
        GridPane.setRowIndex(image, row);
        GridPane.setColumnIndex(image, col);
        GridPane.setRowSpan(image, x);
        GridPane.setColumnSpan(image, x);
       GridPane.setHalignment(image, HPos.LEFT);
       GridPane.setValignment(image, VPos.TOP);
       board.getChildren().add(image);
	}
	public void setLaddrs()
	{
		
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