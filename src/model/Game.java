package model;

import java.util.HashMap;

public class Game {
	private static int gameNum=0;
	private HashMap<Integer,Player> allPlayers; // the participants in the game 
	private HashMap<Integer,Ladder> allLaders; // the ladders among the game
	private HashMap<Integer,Snake> allSnakes; // the snakes among the game 
	private Dice dice;
	private int gameLevel; //game level , 1 -easy , 2 medium , 3 hard
	// timer 1  from the start to the finish 
	// timer 2  for each player how long does it take for each turn 
	 private Player currplayer;
	 private Board board;
	public Game(HashMap<Integer, Player> allPlayers, HashMap<Integer, Ladder> allLaders,
			HashMap<Integer, Snake> allSankes, Dice dice, int gameLevel, Player currplayer,Board board) {
		super();
		this.allPlayers = allPlayers;
		this.allLaders = allLaders;
		this.allSnakes = allSankes;
		this.dice = dice;
		this.gameLevel = gameLevel;
		this.currplayer = currplayer;
		this.board = board;
		gameNum++;
	}
	 // Method to add players to the game
    public void addPlayer(Player player) {
        allPlayers.put(Player.getId(), player);
    }
    //Method to add ladder to the game
    public void addLadder(Ladder lader) {
    	allLaders.put(Ladder.getLadderId(), lader);
    }
    //Method to add snake to the game
    public void addSnake(Snake snake) {
		allSnakes.put(Snake.getSnakeNumber(), snake);
	}
    
    
    
  
	 
	 
	 	
	
	

}