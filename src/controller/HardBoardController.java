package controller;
import java.io.IOException;
import java.net.URL;
import javafx.animation.Timeline;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import utils.Level;
import utils.SnakeColor;
import view.Feedback;
import view.Feedback2;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Dice;
import model.Game;
import model.HelpClass;
import model.Ladder;
import model.Player;
import model.Question;
import model.QuestionSquare;
import model.Snake;
import model.SquareFactory;
import model.SurpriseSquare;
import model.SysData;
import model.TimerClass;
import javafx.scene.image.Image;

public class HardBoardController implements Initializable{
	@FXML
	private GridPane board;
	@FXML
	Text timerCheck;
	@FXML
	AnchorPane anchor1;
	@FXML
	AnchorPane anchor2;
	@FXML
	AnchorPane anchor3;
	@FXML
	ImageView player3FXML;
	@FXML
	ImageView player4FXML;
	@FXML
	Label name1;
	@FXML
	Label name2;
	@FXML
	Label name3;
	@FXML
	Label name4;
	@FXML
	Label current;
	@FXML
	ImageView curentImage;
	@FXML
	ImageView diceImage;
	@FXML
	Text levell;
	@FXML
	Button p1turn;
	@FXML
	Button p2turn;
	@FXML
	Button p3turn;
	@FXML
	Button p4turn;

	SquareFactory fact=new SquareFactory();
	private Player currentPlayer=HelpClass.getInstance().getP1();//assuming
	private Level Level2=HelpClass.getInstance().getLevelGame();
	private int num_of_players=HelpClass.getInstance().getNumOfPlayer();
	private int x=13;
	private Pane[][] panes = new Pane[x][x];
	private  Label label;
	// This hashmap saves what the user see
	private HashMap<Integer,HashMap<Integer,Integer>> boardCells= new HashMap<Integer, HashMap<Integer, Integer>>();
	private HashMap<Integer,Snake> snakesOnBoard = new HashMap<Integer,Snake>();
	private HashMap<Integer,Ladder> laddersOnBoard = new HashMap<Integer,Ladder>();
	private HashMap<Integer,Boolean> ocuupiedCells = new HashMap<Integer,Boolean>();
	private HashMap<Integer,Player> players = new HashMap<Integer,Player>();
	private HashMap<Integer,QuestionSquare> ocuupiedQuestions = new HashMap<Integer,QuestionSquare>();
	private SurpriseSquare surprise1;
	private SurpriseSquare surprise2;
	private ImageView surprisePic1 = new ImageView(new Image("/Images/surprise.png"));
	private ImageView surprisePic2 = new ImageView(new Image("/Images/surprise.png"));
	private int levelForSurprise;
	private int levelForSurprise2;
	private Dice dice; 
	private  Player player1; 
	private  Player player2;
	private  Player player3;
	private  Player player4;
	private Player winner;
	static ArrayList<Question> usedQues = new ArrayList<>();	
	private int result_to_return=0; 
	private int addToResult=0; 
	private int DecResult=0;
	
//	setSnakeToBoardView(red1,40,40,0,0);
//	setSnakeToBoardView(bl,35,150,3,4);
//	setSnakeToBoardView(gr2,60,205,5,6);
//	setSnakeToBoardView(yellow,170,80,2,4);
	
	//60,205
	private ImageView gr1 = new ImageView(new Image("/Images/greenSnake.png"));
	private ImageView gr2 = new ImageView(new Image("/Images/greenSnake.png"));
	//35,150
	private ImageView b1 = new ImageView(new Image("/Images/blueSnake.png"));
	private ImageView b2 = new ImageView(new Image("/Images/blueSnake.png"));

	
	//170,80
	private ImageView yellow = new ImageView(new Image("/Images/yellowSnake.png"));
	private ImageView yellow2 = new ImageView(new Image("/Images/yellowSnake.png"));

	//40,40
	private ImageView red1 = new ImageView(new Image("/Images/redSnake.png"));
	private ImageView red2 = new ImageView(new Image("/Images/redSnake.png"));
	private ArrayList<Game> game1=new ArrayList<Game>();
	/*ladders*/

	//ladder1 , 60,60 
	//ladder2 , 39,500
	//ladder3, 75,236
	//ladder4,87,283
	//ladder5,87,237
	//ladder6 80,275
	//ladder 7 260,320
	//ladder 8 265,358
	private ImageView ladder1 = new ImageView(new Image("/Images/ladder1.png"));
	private ImageView ladder2 = new ImageView(new Image("/Images/ladder2.png"));
	private ImageView ladder3= new ImageView(new Image("/Images/ladder_rotate.png"));
	private ImageView ladder4 = new ImageView(new Image("/Images/ladder_rotate.png"));
	private ImageView ladder5 = new ImageView(new Image("/Images/ladder41.png"));
	private ImageView ladder6 = new ImageView(new Image("/Images/ladder6Hard.png"));
	private ImageView ladder7 = new ImageView(new Image("/Images/ladder4Easy.png"));
	private ImageView ladder8 = new ImageView(new Image("/Images/ladder6.png"));

	private ImageView player1Image = new ImageView(new Image("/Images/egy1.png"));
	private ImageView player2Image = new ImageView(new Image("/Images/egyy2.png"));
	private ImageView player3Image = new ImageView(new Image("/Images/egyy3.png"));
	private ImageView player4Image = new ImageView(new Image("/Images/egyy4.png"));
	static Stage window = new Stage();

	//*************************************************************//
	private void initializeOccupiedCells(int x) {
		for (int i = 1; i <= x*x; i++) {
			ocuupiedCells.put(i, false);
		}
	}
	/***************************************************************/
	// a way to go from row and col to actual value.
	private int calLabelValue(int row,int col)
	{
		int labelValue;
		if (row % 2 == 1) {
			labelValue = ((x - row) * x - col);
		} else {
			labelValue = ((x - row) * x - (x - col - 1));
		}
		return labelValue;
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
	/****************************************************************************/

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
	/*******************************************************************************/
	private final Color[] allowedColors = {
			Color.web("white"),
			Color.web("#FDA50F"),
	};
	/*************************************************/
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Populate the GridPane with Panes using allowed colors
		SysData.getInstance().loadQ("Questions.json");
		int rows = x;
		int cols = x;
		initializeOccupiedCells(x);
		setBoardCells(x);
		board.setPrefSize(550, 550);
		startBoard(rows,cols,x); //This function starts the board and number the cells
		configureGridPane(); // This function colors the board
		setLaddrs();
		setSnakes();
		//setSquare();
		/***************lets start the game**************************/
		// we assumed that we will start with player 1 ====> lets disable other buttons
		startGame();
	}
	
	
	@FXML
	private void removeButton(Button x) {
		// Assuming the button's parent is an AnchorPane
		AnchorPane parent = (AnchorPane) x.getParent();
		parent.getChildren().remove(x);
	}
	/**********************************************************************/
	boolean IsEnds = false;
	TimerClass startTime = new TimerClass("0:0:0");
	Timeline timeline1 = new Timeline(
			new KeyFrame(Duration.seconds(1),
					e -> {
						if (IsEnds) {
							// Reset timerCheck to "0:0:0" when IsEnds is true
							timerCheck.setText("0:0:0");
						} else {
							// If IsEnds is false, continue updating timerCheck with current time
							startTime.oneSecondPassed();
							timerCheck.setText(startTime.getCurrentTime());
						}

					}

					));
	/*********************************************************************/
	public void startGame()
	{

		timeline1.setCycleCount(Timeline.INDEFINITE);
		timeline1.play();
		timerCheck.setText(startTime.getCurrentTime());
		if(Level2.equals(Level.Hard))
		{
			dice=new Dice(0,15,Level.Hard); 
		}
		
		
		p2turn.setDisable(true);
		p3turn.setDisable(true);
		p4turn.setDisable(true);
		levell.setText(Level2.toString());
		curentImage.setImage(new Image(HelpClass.getInstance().getP1().getAvatarPath()));
		if(num_of_players==2)
		{
			player1=HelpClass.getInstance().getP1();
			player2 =HelpClass.getInstance().getP2();
			players.put(player1.getPlayerId(), player1);
			players.put(player2.getPlayerId(), player2);
			name1.setText(player1.getNickName());
			name2.setText(player2.getNickName());
			current.setText(player1.getNickName());
			removeButton(p3turn);
			removeButton(p4turn);
		}
		if(num_of_players==3)
		{
			player1=HelpClass.getInstance().getP1();
			player2 =HelpClass.getInstance().getP2();	
			player3=HelpClass.getInstance().getP3();
			players.put(player1.getPlayerId(), player1);
			players.put(player2.getPlayerId(), player2);
			players.put(player3.getPlayerId(), player3);
			name1.setText(player1.getNickName());
			name2.setText(player2.getNickName());
			name3.setText(player3.getNickName());
			player3FXML.setImage(new Image(player3.getAvatarPath()));
			current.setText(player1.getNickName());
			removeButton(p4turn);	
		}
		if(num_of_players==4)
		{
			player1=HelpClass.getInstance().getP1();
			player2 =HelpClass.getInstance().getP2();	
			player3=HelpClass.getInstance().getP3();
			player4=HelpClass.getInstance().getP4();
			players.put(player1.getPlayerId(), player1);
			players.put(player2.getPlayerId(), player2);
			players.put(player3.getPlayerId(), player3);
			players.put(player4.getPlayerId(), player4);
			name1.setText(player1.getNickName());
			name2.setText(player2.getNickName());
			name3.setText(player3.getNickName());
			name4.setText(player4.getNickName());
			player3FXML.setImage(new Image(player3.getAvatarPath()));
			player4FXML.setImage(new Image(player4.getAvatarPath()));
			current.setText(player1.getNickName());
		}	
	}
	/**************************************************************************/
	/*public void numOfPlayers(int numOfPlayers) this function for the if's apove.
	{
		for(int i=0;i<numOfPlayers;i++)
		{
			player=HelpClass.getInstance().getP1();
		}
	}*/

	/********************functions for the game *******************************/
	@FXML
	public void startPlaying(ActionEvent e)
	{
		diceImage.setImage(new Image("/Images/diceGif.gif"));
		PauseTransition pause = new PauseTransition(Duration.seconds(3)); //moves the video for 3 seconds and show us the result
		pause.setOnFinished(event -> { // the final result of the dice
			int diceResult=dice.getResult();

			if (diceResult == 0) {
				diceImage.setImage(new Image("/Images/Dice0.png"));
			} else if (diceResult == 1) {
				diceImage.setImage(new Image("/Images/Dice1.png"));
			} else if (diceResult == 2) {
				diceImage.setImage(new Image("/Images/Dice2.png"));
			} else if (diceResult == 3) {
				diceImage.setImage(new Image("/Images/Dice3.png"));
			} else if (diceResult == 4) {
				diceImage.setImage(new Image("/Images/Dice4.png"));
			} else if (diceResult == 5) {
				diceImage.setImage(new Image("/Images/Dice5.png"));
			} else if (diceResult == 6) {
				diceImage.setImage(new Image("/Images/Dice6.png"));
			} else if (diceResult == 7 || diceResult == 8) {
				diceImage.setImage(new Image("/Images/DiceEasy.png"));
			} else if (diceResult == 9 || diceResult == 10) {
				diceImage.setImage(new Image("/Images/DiceMedium.png"));
			} else if (diceResult > 10 && diceResult < 15) {
				diceImage.setImage(new Image("/Images/DiceHard.png"));
			}

			//start the real game
			if(e.getSource()==p1turn)
			{
				handle_movement(player1,diceResult,"p1");
			}
			if(e.getSource()==p2turn)
			{
				handle_movement(player2,diceResult,"p2");

			}
			if(e.getSource()==p3turn)
			{
				handle_movement(player3,diceResult,"p3");

			}
			if(e.getSource()==p4turn)
			{
				handle_movement(player4,diceResult,"p4");

			}

		});

		pause.play();

	}

	private void handle_movement(Player p, int diceResult,String type)
	{
		int num1=6;
		int current_pos,next_pos;
		if(diceResult < 7){	
			currentPlayer=p;
			current_pos=p.getPosition();
			if(current_pos+diceResult<=x*x) {
				next_pos=current_pos+diceResult;
				num1=check_move(p,next_pos,type);
			}
			if(num1!=0) {disbaleButtons();}
		}
		else
		{
			//if right wont move , other will get back 1 step
			display_question(diceResult,p,type);
			/*currentPlayer=p;
		  current_pos=p.getPosition();
		  if(current_pos+result_to_return<=x*x && current_pos+result_to_return>=1) {
		  next_pos=current_pos+result_to_return;
		  check_move(p,next_pos,type);
           }
		  disbaleButtons();*/
		}
	}
	private int current_pos_q;
	private int next_player_q;
	private int have_winner=6;
	private boolean display_question(int diceResult,Player p,String type)
	{
		Stage window3 = new Stage();  // Create a new Stage
		result_to_return=0;
		addToResult=0;
		DecResult=0;
		Question question1 = null;
		if(diceResult==7||diceResult==8)// we got easy question
		{
			question1 = getEasyQuestion();

		}
		else
		{
			if(diceResult==9||diceResult==10)
			{
				question1 = getMediumQuestion();

			}
			else
			{
				if(diceResult>10&&diceResult<15)
				{
					question1 = getHardQuestion();

				}
			}
		}
		Question q = new Question(question1.getQuestionContent(),question1.getLevel(),question1.getAnswer1()
				,question1.getAnswer2(),question1.getAnswer3(),question1.getAnswer4(),question1.getCorrectAnswerNumber());
		//we have the question here so lets check answer and display it
		window3.setTitle("Try answer the question" + q.getLevel());
		window3.setMinWidth(500);
		window3.setMinHeight(200);
		Label question = new Label("Question:");
		Text questionText = new Text(q.getQuestionContent());
		RadioButton a1 = new RadioButton(q.getAnswer1());
		RadioButton a2 = new RadioButton(q.getAnswer2());
		RadioButton a3 = new RadioButton(q.getAnswer3());
		RadioButton a4 = new RadioButton(q.getAnswer4());
		/* RadioButton[] answerButtons = new RadioButton[4];
		    for (int i = 0; i < 4; i++) {
		        answerButtons[i] = new RadioButton(question.getAnswers()[i]);
		    }*/
		ToggleGroup tg = new ToggleGroup(); 
		a1.setToggleGroup(tg);
		a2.setToggleGroup(tg);
		a3.setToggleGroup(tg);
		a4.setToggleGroup(tg);
		Button sub = new Button("Submit");
		question.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		questionText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		sub.setStyle(
                "-fx-background-radius: 30; -fx-min-width: 30px; -fx-min-height: 30px; " +
                "-fx-background-color: #ffa089;");
		sub.setOnAction(e->{
			if(!a1.isSelected() && !a2.isSelected() &&  !a3.isSelected() &&  !a4.isSelected()) {
				Feedback.message("Error", "Please answer the question");
				return;
			}
			if(q.getLevel().equals(Level.Easy)) {
				addToResult=0;
				DecResult=-1;
			}
			if(q.getLevel().equals(Level.Medium)) {
				addToResult=0;
				DecResult=-2;
			}
			if(q.getLevel().equals(Level.Hard)) {
				addToResult=1;
				DecResult=-3;
			}
			/********************this should be in function***************************/
			if ((q.getCorrectAnswerNumber() == 1 && a1.isSelected()) ||
				    (q.getCorrectAnswerNumber() == 2 && a2.isSelected()) ||
				    (q.getCorrectAnswerNumber() == 3 && a3.isSelected()) ||
				    (q.getCorrectAnswerNumber() == 4 && a4.isSelected())) {
				    Feedback2.message("right", "right answer ");
				    result_to_return = addToResult;
				} else {
				    Feedback.message("Wrong", "wrong answer");
				    result_to_return = DecResult;
				}

				currentPlayer = p;
				current_pos_q = p.getPosition();
				if (current_pos_q + result_to_return <= x * x && current_pos_q + result_to_return >= 1) {
				    next_player_q = current_pos_q + result_to_return;
				    have_winner=check_move(p, next_player_q, type);
				}
				if(have_winner!=0) {disbaleButtons();}
				window3.close();
			/************************to here***********************************/
		});
		System.out.print("reached here");
		VBox vbox = new VBox();

		vbox.getChildren().addAll(question, questionText,a1, a2, a3, a4, sub);
		BackgroundFill backgroundFill = new BackgroundFill(javafx.scene.paint.Color.web("#ffcba4"), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        vbox.setBackground(background);
		Scene scene = new Scene(vbox, 50, 40);
		window3.setScene(scene);
		window3.show();
		
		return false;
	}
	private Question getEasyQuestion() {
		ArrayList<Question>ques = new ArrayList<>(SysData.getInstance().getAllQuestions());
		ArrayList<Question>easy = new ArrayList<>();
		for(Question q : ques) {
			if(q.getLevel().equals(Level.Easy)) {
				easy.add(q);
			}
		}
		Collections.shuffle(easy);
		return easy.get(0);

	}
	private Question getMediumQuestion() {

		ArrayList<Question>ques = new ArrayList<>(SysData.getInstance().getAllQuestions());
		ArrayList<Question>medium = new ArrayList<>();


		for(Question q : ques) {
			if(q.getLevel().equals(Level.Medium)) {
				medium.add(q);
			}
		}
		Collections.shuffle(medium);
		return medium.get(0);

	}

	private Question getHardQuestion() {
		ArrayList<Question>ques = new ArrayList<>(SysData.getInstance().getAllQuestions());
		ArrayList<Question>hard = new ArrayList<>();

		for(Question q : ques) {
			if(q.getLevel().equals(Level.Hard)) {
				hard.add(q);
			}
		}
		Collections.shuffle(hard);
		return hard.get(0);

	}

	private int check_winner(int pos ,String type)
	{
		
		int c=1;
		if(pos==x*x)
		{
			c=0;
			if(type=="p1") {winner=player1;}
			if(type=="p2") {winner=player2;}
			if(type=="p3") {winner=player3;}
			if(type=="p4") {winner=player4;}
			Stage window3 = new Stage();
			window3.setTitle("THERE IS A WINNER");
			window3.setMinWidth(500);
			window3.setMinHeight(200);
			Label win = new Label("winner is:"+winner.getNickName());
			Button sub = new Button("continue");
			VBox vbox = new VBox();
			vbox.getChildren().addAll(win,sub);
			sub.setStyle(
	                "-fx-background-radius: 30; -fx-min-width: 30px; -fx-min-height: 30px; " +
	                "-fx-background-color: #ffa089;");
			sub.setOnAction(e->{
				window3.close();
				});
			BackgroundFill backgroundFill = new BackgroundFill(javafx.scene.paint.Color.web("#ffcba4"), CornerRadii.EMPTY, Insets.EMPTY);
	        Background background = new Background(backgroundFill);
	        vbox.setBackground(background);
			Scene scene = new Scene(vbox, 50, 40);
			window3.setScene(scene);
			window3.show();
			p1turn.setDisable(true);
			p2turn.setDisable(true);
			p3turn.setDisable(true);
			p4turn.setDisable(true);
			timeline1.stop();
			Game game=new Game(Level2,winner,timerCheck.getText());
			game1=Main.res.getAllgames();
			game1.add(game);
			Main.res.setAllgames(game1);
			Main.update();
			return c;
			
		}
		return c;
		
		
	}
	private int check_move(Player p , int position,String type)
	{
		
		ImageView v;
		HashMap<Integer , Integer > map ;
		int row=0,col=0;
		int lad=check_ladder(position);// if -1 then no ladder here
		int snake1 = check_snake(position);//-1
		int square = check_square(position,p,type);
		//if(square==1) return;
		if(position==levelForSurprise||position==levelForSurprise2) {
			if(position+10<=x*x)
			{
				check_move(p,position+10,type);
				return 3;
			}
			else
			{
				return 3;
			}
		}
		if(lad!=-1)//it means we have ladder
		{
			position=lad;
		}
		else
		{
			if(snake1!=-1)//we have snake
			{
				position=snake1;
			}
		}
		p.setPosition(position);
		map =  boardCells.get(position); 
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
			System.out.print("posi ="+position+"row"+row+"col"+col);
		}
		if(type=="p1") { // in this condtion we update the postion of each plauer 
			board.getChildren().remove(player1Image);
			setSnakeToBoardView(player1Image,40,40,row,col);
			
			
		}
		if(type=="p2")
		{
			board.getChildren().remove(player2Image);
			setSnakeToBoardView(player2Image,40,40,row,col);
		}
		if(type=="p3")
		{
			board.getChildren().remove(player3Image);
			setSnakeToBoardView(player3Image,40,40,row,col);
		}
		if(type=="p4")
		{
			board.getChildren().remove(player4Image);
			setSnakeToBoardView(player4Image,40,40,row,col);
		}
		if(check_winner(position,type)==0)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	private int check_square(int position,Player p,String type)
	{
        QuestionSquare res=ocuupiedQuestions.get(new Integer(position));
		if(res!=null)
		{
	         p.setPosition(position);
			 if(res.getType()=="Easy")
			 {
				 display_question(7,p,type);
			 }
			 if(res.getType()=="Medium")
			 {
				 display_question(9,p,type);
			 }
			 if(res.getType()=="Hard")
			 {
				 display_question(11,p,type);
			 }
			 return 1;
		}
		return 0;
	}
	/*****************************************************************/
	private int check_snake(int position)
	{
		int pos=-1;
		for (Snake snake : snakesOnBoard.values()) {
			if(snake.getSquareStart()==position)
			{
				if(snake.getSnakeColor().equals(SnakeColor.red))
					pos = 1;
				else {
					pos=snake.getSquareEnd();
				}
			}
		}
		return pos;// if -1 returned it means no snake
	}
	/*********************************************************************/
	private int check_ladder(int position)
	{
		int pos=-1;
		for (Ladder ladder : laddersOnBoard.values()) {
			if(ladder.getSquareEnd()== position)
			{
				pos=ladder.getSquareStart();
			}
		}
		return pos;// if -1 returned it means no ladder
	}
	/**************************************************************************/
	//disable buttons
	private void disbaleButtons() //this function for the on and off of each player
	{
		if(currentPlayer==player1)
		{
			if(num_of_players==2)
			{
				p1turn.setDisable(true);
				p2turn.setDisable(false);

			}
			if(num_of_players==3)
			{
				p1turn.setDisable(true);
				p2turn.setDisable(false);
				p3turn.setDisable(true);
			}
			if(num_of_players==4)
			{
				p1turn.setDisable(true);
				p2turn.setDisable(false);
				p3turn.setDisable(true);
				p4turn.setDisable(true);
			}
			curentImage.setImage(new Image(player2.getAvatarPath()));
			current.setText(player2.getNickName());
		}
		if(currentPlayer==player2)
		{
			if(num_of_players==2)
			{
				p1turn.setDisable(false);
				p2turn.setDisable(true);
				curentImage.setImage(new Image(player1.getAvatarPath()));
				current.setText(player1.getNickName());
			}
			if(num_of_players==3)
			{
				p1turn.setDisable(true);
				p2turn.setDisable(true);
				p3turn.setDisable(false);
				curentImage.setImage(new Image(player3.getAvatarPath()));
				current.setText(player3.getNickName());
			}
			if(num_of_players==4)
			{
				p1turn.setDisable(true);
				p2turn.setDisable(true);
				p3turn.setDisable(false);
				p4turn.setDisable(true);
				curentImage.setImage(new Image(player3.getAvatarPath()));
				current.setText(player3.getNickName());
			}
		}
		if(currentPlayer==player3)
		{
			if(num_of_players==3)
			{
				p1turn.setDisable(false);
				p2turn.setDisable(true);
				p3turn.setDisable(true);
				curentImage.setImage(new Image(player1.getAvatarPath()));
				current.setText(player1.getNickName());
			}
			if(num_of_players==4)
			{
				p1turn.setDisable(true);
				p2turn.setDisable(true);
				p3turn.setDisable(true);
				p4turn.setDisable(false);
				curentImage.setImage(new Image(player4.getAvatarPath()));
				current.setText(player4.getNickName());
			}
		}
		if(currentPlayer==player4)
		{
			p1turn.setDisable(false);
			p2turn.setDisable(true);
			p3turn.setDisable(true);
			p4turn.setDisable(true);
			curentImage.setImage(new Image(player1.getAvatarPath()));
			current.setText(player1.getNickName());
		}
	}
	/******************************end*************************************/
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
		return labelValue; 
	}
	public void setSquare() // sets surprise and question
	{
		int row=0,col=0;
		HashMap<Integer , Integer > map ;
		int labelValue = setObjCheckOcuupied();
		for(int i=0;i<2;i++) {
			while(labelValue > ((x*x)-10)) // can't jump over the end 
				labelValue = setObjCheckOcuupied();
			ocuupiedCells.put(labelValue, true);
			row=0;
			col=0;
			map =  boardCells.get(labelValue); 
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				row = entry.getKey();
				col = entry.getValue();
			}
			if(i==0) {
				surprisePic1.setFitWidth(40);
				surprisePic1.setFitHeight(40);
				SurpriseSquare sq1=(SurpriseSquare)fact.getType("SurpriseSquare", row, col);
				surprise1=sq1;
				levelForSurprise=labelValue;
				GridPane.setConstraints(surprisePic1, col, row,1,1);//first is column , second is row,
				board.getChildren().add(surprisePic1);
			}
			if(i==1) {
				surprisePic2.setFitWidth(40);
				surprisePic2.setFitHeight(40);
				SurpriseSquare sq2=(SurpriseSquare)fact.getType("SurpriseSquare", row, col);
				surprise2=sq2;
				levelForSurprise2=labelValue;
				GridPane.setConstraints(surprisePic2, col, row,1,1);//first is column , second is row,
				board.getChildren().add(surprisePic2);
			}
			
		}
		/***start question square**/
		String type="Easy";
		for(int i=0;i<3;i++) /********questions for the random set in the board*///////////
		{
			if(i==0) {type="Easy";}
			if(i==1) {type="Medium";}
			if(i==2) {type="Hard";}
			labelValue = setObjCheckOcuupied();
			while(labelValue==100) { labelValue = setObjCheckOcuupied();}
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
			QuestionSquare question_fact=(QuestionSquare)fact.getType(type,row, col);
			
			GridPane.setConstraints(question, col, row,1,1);
			board.getChildren().add(question);
			ocuupiedQuestions.put(labelValue,question_fact);
			
		}
	}
	private int calcEnd(int labelValue,int stepsRow,int stepsCol)
	{
		HashMap<Integer , Integer > map ;
		int row=0;
		int col=0;
		int endValue;
		map =  boardCells.get(labelValue);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
		}
		endValue = calLabelValue(row+stepsRow, col+stepsCol);
		return endValue;
	}
	private int checkEmptyCells(int first,int end)
	{
		HashMap<Integer , Integer > map ;
		int rowF=0,rowE=0;
		int colF=0,colE=0;
		map =  boardCells.get(first);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			rowF = entry.getKey();
			colF = entry.getValue();
		}
		map =  boardCells.get(end);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			rowE = entry.getKey();
			colE = entry.getValue();
		}
		int number;
		int check=1;
		for(int i=rowF;i<rowE;i++)
		{
			number=calLabelValue(i, colF);
			if(ocuupiedCells.get(number)==true)
			{
				check=0;
			}
		}

		return check;
	}
	
	
	
	//rotation check
	private int checkEmptyCellsRotate(int first,int end)
	{
		HashMap<Integer , Integer > map ;
		int rowF=0,rowE=0;
		int colF=0,colE=0;
		map =  boardCells.get(first);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			rowF = entry.getKey();
			colF = entry.getValue();
		}
		map =  boardCells.get(end);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			rowE = entry.getKey();
			colE = entry.getValue();
		}
		int number;
		int check=1;
		int col2=colF;
		for(int i=rowF+1;i<rowE;i++)
		{
			number=calLabelValue(i, colF);
			if(ocuupiedCells.get(number)==true)
			{
				check=0;
			}
			colF++;
		}
		

		return check;
	}
	//this method checks if the cells yellow snake take are not occupied
	private int checkEmptyCellsForYellow(int row,int col) // this function for yellow snake because the yellow snake is very large 
	{
		int check=1;
		int number;
		for(int i=col;i<col+2;i++)
		{
			number=calLabelValue(row+1,i);
			if(ocuupiedCells.get(number)==true)
			{
				check=0;
			}
		}
		return check;
	}
	// this method is used to set all panes of object as occupied so the ui will be more ...//
	private void setAllBetweenOccupied(int first,int end,int num)
	{
		HashMap<Integer , Integer > map ;
		int rowF=0,rowE=0;
		int colF=0,colE=0;
		map =  boardCells.get(first);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			rowF = entry.getKey();
			colF = entry.getValue();
		}
		map =  boardCells.get(end);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			rowE = entry.getKey();
			colE = entry.getValue();
		}
		int number;
		int check=1;
		int col2=colF;
		for(int i=rowF+num;i<rowE;i++)
		{
			number=calLabelValue(i, colF);
			ocuupiedCells.put(number,true);
			colF+=num;
		}	
		if(num==1)
		{
			for(int i=rowF+2;i<rowE;i++)
			{
				number=calLabelValue(i, col2);
				ocuupiedCells.put(number,true);
				col2+=num;
			}	
		}
	}
	
	//this methos set panes which yellow snake take as occupied
	private void setAllBetYellowOccupied(int row,int col)
	{
		int number;
		for(int i=col;i<col+2;i++)
		{
			number=calLabelValue(row+1,i);
			ocuupiedCells.put(number,true);
		}
	}
	public void setSnakes()
	{
		Snake snake = null;
		int labelValue = 0;
		int endValue=0;
		/*********first Kind red snakes*********/
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
		HashMap<Integer , Integer > map ;
		int row=0;
		int col=0;
		for(int i=0;i<2;i++) {
			labelValue = setObjCheckOcuupied();
			endValue = calcEnd(labelValue,3,0);
			while((labelValue == x*x) || (labelValue < 40)||ocuupiedCells.get(endValue)==null||ocuupiedCells.get(endValue)==true||checkEmptyCells(labelValue,endValue)==0) { // Can't be at the end or the start
				labelValue = setObjCheckOcuupied();
				endValue = calcEnd(labelValue,3,0);
			}
			map =  boardCells.get(labelValue); 
			row = 0;
			col = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				row = entry.getKey();
				col = entry.getValue();
			}
			snake = new Snake(labelValue,endValue,SnakeColor.blue);
			ocuupiedCells.put(labelValue, true);
			setAllBetweenOccupied(labelValue,endValue,0);
			ocuupiedCells.put(endValue, true);
	
			snakesOnBoard.put(labelValue, snake);
			if(i == 0)
				setSnakeToBoardView(b1,35,150,row,col);
			if (i==1)
				setSnakeToBoardView(b2,35,150,row,col);
		}


		/****************yellow Snake *******************/
		for(int i=0;i<2;i++) {
			labelValue = setObjCheckOcuupied();
			map =  boardCells.get(labelValue); 
			row = 0;
			col = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				row = entry.getKey();
				col = entry.getValue();
			}
			endValue = calcEnd(labelValue,1,2);
			while((labelValue == x*x) || (labelValue < 14)||col==x-1||col==x-2||ocuupiedCells.get(endValue)==null||ocuupiedCells.get(endValue)==true||checkEmptyCellsForYellow(row,col)==0) { // Can't be at the end or the start
				labelValue = setObjCheckOcuupied();
				endValue = calcEnd(labelValue,1,2);
				map =  boardCells.get(labelValue); 
				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					row = entry.getKey();
					col = entry.getValue();
				}
			}
			map =  boardCells.get(labelValue);
			row = 0;
			col = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				row = entry.getKey();
				col = entry.getValue();
			}
			snake = new Snake(labelValue,endValue,SnakeColor.yellow);
			ocuupiedCells.put(labelValue, true);
			setAllBetYellowOccupied(row,col);
			ocuupiedCells.put(endValue, true);
			snakesOnBoard.put(labelValue, snake);
			if(i==0) {
			  setSnakeToBoardView(yellow,170,80,row,col);
			}
			if(i==1)
			{
			  setSnakeToBoardView(yellow2,170,80,row,col);
			}
		}
		/************Green Snake**************************/
		for(int i=0;i<2;i++) {
			labelValue = setObjCheckOcuupied();
			endValue = calcEnd(labelValue,2,0);
			while((labelValue == x*x) ||(labelValue < 39)||ocuupiedCells.get(endValue)==null||ocuupiedCells.get(endValue)==true||checkEmptyCells(labelValue,endValue)==0) { // Can't be at the end or the start
				labelValue = setObjCheckOcuupied();
				endValue = calcEnd(labelValue,2,0);
			}
			map =  boardCells.get(labelValue); 
			row=0;
			col=0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				row = entry.getKey();
				col = entry.getValue();
			}
			snake = new Snake(labelValue,endValue,SnakeColor.green);
			ocuupiedCells.put(labelValue, true);
			setAllBetweenOccupied(labelValue,endValue,0);
			ocuupiedCells.put(endValue, true);
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
	public void setLaddrs() {
		Ladder ladder = null;
		int labelValue = setObjCheckOcuupied();
		int endValue=0;
		
        /**ladder8**/
		
		endValue = calcEnd(labelValue,8,5);
		HashMap<Integer, Integer> map = boardCells.get(labelValue);
		int row = 0;
		int col = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
		}
		while (row>4||col>7||ocuupiedCells.get(endValue)==null||ocuupiedCells.get(endValue)==true||checkEmptyCellsRotate(labelValue,endValue)==0) {
			labelValue = setObjCheckOcuupied();
			endValue = calcEnd(labelValue,8,5);
			map = boardCells.get(labelValue);
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				row = entry.getKey();
				col = entry.getValue();
			}
		}
		map = boardCells.get(labelValue);
		row = 0;
		col = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
		}
		ladder = new Ladder(labelValue,endValue,8,Level.Hard);
		ocuupiedCells.put(labelValue, true);
		setAllBetweenOccupied(labelValue,endValue,1);
		ocuupiedCells.put(endValue, true);
		laddersOnBoard.put(labelValue, ladder);
		setSnakeToBoardView(ladder8, 265,358, row, col);
		
		
        /**ladder7**/
		
		endValue = calcEnd(labelValue,7,4);
	    map = boardCells.get(labelValue);
	    row = 0;
		col = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
		}
		while (row>5||col>8||ocuupiedCells.get(endValue)==null||ocuupiedCells.get(endValue)==true||checkEmptyCellsRotate(labelValue,endValue)==0) {
			labelValue = setObjCheckOcuupied();
			endValue = calcEnd(labelValue,7,4);
			map = boardCells.get(labelValue);
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				row = entry.getKey();
				col = entry.getValue();
			}
		}
		map = boardCells.get(labelValue);
		row = 0;
		col = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
		}
		ladder = new Ladder(labelValue,endValue,7,Level.Hard);
		ocuupiedCells.put(labelValue, true);
		setAllBetweenOccupied(labelValue,endValue,1);
		ocuupiedCells.put(endValue, true);
		laddersOnBoard.put(labelValue, ladder);
		setSnakeToBoardView(ladder7, 260,320, row, col);
		
		/**************** ladder 6 in medium level******************/
		labelValue = setObjCheckOcuupied();
		endValue = calcEnd(labelValue,6,0);

		while ((labelValue <79)||ocuupiedCells.get(endValue)==null||ocuupiedCells.get(endValue)==true||checkEmptyCells(labelValue,endValue)==0) { // Can't be at the end or the start
			labelValue = setObjCheckOcuupied();
			endValue = calcEnd(labelValue,6,0);
			
		}
		 map = boardCells.get(labelValue);
		 row = 0;
		 col = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
		}
		ladder = new Ladder(labelValue,endValue,6,Level.Hard);
		ocuupiedCells.put(labelValue, true);
		ocuupiedCells.put(endValue, true);
		laddersOnBoard.put(labelValue, ladder);
		setAllBetweenOccupied(labelValue,endValue,0);
		setSnakeToBoardView(ladder6, 80, 275, row, col);
		
		
         
		
		/****** ladder 5 in Medium level *******/
		labelValue = setObjCheckOcuupied();
		endValue = calcEnd(labelValue,5,0);

		while ((labelValue < 66)||ocuupiedCells.get(endValue)==null||ocuupiedCells.get(endValue)==true||checkEmptyCells(labelValue,endValue)==0) { // Can't be less than 51 
			labelValue = setObjCheckOcuupied();
			endValue = calcEnd(labelValue,5,0);

		}
		map = boardCells.get(labelValue);
		row = 0;
		col = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
		}
		ladder = new Ladder(labelValue,endValue,5,Level.Hard);
		ocuupiedCells.put(labelValue, true);
		setAllBetweenOccupied(labelValue,endValue,0);

		ocuupiedCells.put(endValue, true);

		laddersOnBoard.put(labelValue, ladder);
		setSnakeToBoardView(ladder5, 87, 237, row, col);
		
		
		/*********************ladder 4*********************************/
		labelValue = setObjCheckOcuupied();
		endValue = calcEnd(labelValue,4,1);
		map = boardCells.get(labelValue);
		row = 0;
		col = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
		}
		while ((labelValue < 53|| col==x-1)||ocuupiedCells.get(endValue)==null||ocuupiedCells.get(endValue)==true||checkEmptyCells(labelValue,endValue)==0) { // Can't be less than 31 
			labelValue = setObjCheckOcuupied();
			endValue = calcEnd(labelValue,4,1);
			map = boardCells.get(labelValue);
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				row = entry.getKey();
				col = entry.getValue();
			}

		}
		ladder = new Ladder(labelValue,endValue,4,Level.Hard);
		ocuupiedCells.put(labelValue, true);
		setAllBetweenOccupied(labelValue,endValue,0);
		ocuupiedCells.put(endValue, true);

		laddersOnBoard.put(labelValue, ladder);
		setSnakeToBoardView(ladder4, 87, 283, row, col);
		
		
		/*********************ladder 3*********************************/
		labelValue = setObjCheckOcuupied();
		endValue = calcEnd(labelValue,3,1);
		map = boardCells.get(labelValue);
		row = 0;
		col = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
		}
		while ((labelValue < 40|| col==x-1)||ocuupiedCells.get(endValue)==null||ocuupiedCells.get(endValue)==true||checkEmptyCells(labelValue,endValue)==0) { // Can't be less than 31 
			labelValue = setObjCheckOcuupied();
			endValue = calcEnd(labelValue,3,1);
			map = boardCells.get(labelValue);
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				row = entry.getKey();
				col = entry.getValue();
			}

		}
		ladder = new Ladder(labelValue,endValue,3,Level.Hard);
		ocuupiedCells.put(labelValue, true);
		setAllBetweenOccupied(labelValue,endValue,0);
		ocuupiedCells.put(endValue, true);

		laddersOnBoard.put(labelValue, ladder);
		setSnakeToBoardView(ladder3, 75, 236, row, col);
		

		/*******************ladder 2 in hard level****************/
		labelValue = setObjCheckOcuupied();
		endValue = calcEnd(labelValue,2,0);
		while ((labelValue <27)||ocuupiedCells.get(endValue)==true||ocuupiedCells.get(endValue)==null||checkEmptyCells(labelValue,endValue)==0) { // Can't be at the end or the start
			labelValue = setObjCheckOcuupied();
			endValue = calcEnd(labelValue,2,0);
		}
		map = boardCells.get(labelValue);
		row = 0;
		col = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
		}
		ladder = new Ladder(labelValue,endValue,2,Level.Hard);
		ocuupiedCells.put(labelValue, true);
		ocuupiedCells.put(endValue, true);
		setAllBetweenOccupied(labelValue,endValue,0);
		laddersOnBoard.put(labelValue, ladder);//39,135
		setSnakeToBoardView(ladder2, 39, 500, row, col);
		
		/****** ladder 1 in Medium level********/
		labelValue = setObjCheckOcuupied();
		endValue = calcEnd(labelValue,1,0);
		while ((labelValue <14)||ocuupiedCells.get(endValue)==true||ocuupiedCells.get(endValue)==null||checkEmptyCells(labelValue,endValue)==0) { // Can't be at the end or the start
			labelValue = setObjCheckOcuupied();
			endValue = calcEnd(labelValue,1,0);
		}
		map = boardCells.get(labelValue);
		row = 0;
		col = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			row = entry.getKey();
			col = entry.getValue();
		}
		ladder = new Ladder(labelValue,endValue,1,Level.Hard);
		ocuupiedCells.put(labelValue, true);
		ocuupiedCells.put(endValue, true);
		setAllBetweenOccupied(labelValue,endValue,0);
		laddersOnBoard.put(labelValue, ladder);//39,135
		setSnakeToBoardView(ladder1, 40,80, row, col);
		

		/**************try rotate**************/


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
				panes[row][col].setMinSize(cellWidth, cellHeight);
				panes[row][col].setMaxSize(cellWidth, cellHeight);			}
		}

		board.layout();

	}
	private String toHex(Color color) {
		return String.format("#%02X%02X%02X",
				(int) (color.getRed() * 255),
				(int) (color.getGreen() * 255),
				(int) (color.getBlue() * 255));
	}
}