package model;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


import utils.Level;

public class Game {
	private static int gameNum=0;
	private HashMap<Integer,Player> allPlayers; // the participants in the game 
	private HashMap<Integer,Ladder> allLaders; // the ladders among the game
	private HashMap<Integer,Snake> allSnakes; // the snakes among the game 
	private Dice dice;
	private Level gameLevel; //game level , 1 -easy , 2 medium , 3 hard
	private Player currplayer;
	private Board board;
	private Timer gameTimer;
	public Game(Dice dice, Level gameLevel, Player currplayer, Board board, Timer gameTimer) {
		super();
		this.dice = dice;
		this.gameLevel = gameLevel;
		this.currplayer = currplayer;
		this.board = board;
		this.gameTimer = gameTimer;
		allPlayers=new  HashMap<Integer,Player>();
		allLaders=new  HashMap<Integer,Ladder>();
		allSnakes=new  HashMap<Integer,Snake>();


		
	}

	public void add_player(Player p)
	{
		allPlayers.put(p.getPlayerId(), p);
	}
	public void add_Snake(Snake s)
	{
		allSnakes.put(s.getSnakeNumber(), s);
	}
	public void add_ladder(Ladder l)
	{
		allLaders.put(l.getLadderNum(), l);
	}

	public static int getGameNum() {
		return gameNum;
	}

	public static void setGameNum(int gameNum) {
		Game.gameNum = gameNum;
	}

	public HashMap<Integer, Player> getAllPlayers() {
		return allPlayers;
	}

	public void setAllPlayers(HashMap<Integer, Player> allPlayers) {
		this.allPlayers = allPlayers;
	}

	public HashMap<Integer, Ladder> getAllLaders() {
		return allLaders;
	}

	public void setAllLaders(HashMap<Integer, Ladder> allLaders) {
		this.allLaders = allLaders;
	}

	public HashMap<Integer, Snake> getAllSnakes() {
		return allSnakes;
	}

	public void setAllSnakes(HashMap<Integer, Snake> allSnakes) {
		this.allSnakes = allSnakes;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public Level getGameLevel() {
		return gameLevel;
	}

	public void setGameLevel(Level gameLevel) {
		this.gameLevel = gameLevel;
	}

	public Player getCurrplayer() {
		return currplayer;
	}

	public void setCurrplayer(Player currplayer) {
		this.currplayer = currplayer;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Timer getGameTimer() {
		return gameTimer;
	}

	public void setGameTimer(Timer gameTimer) {
		this.gameTimer = gameTimer;
	}
	
	
	

	

	 
	 	
	
	

}