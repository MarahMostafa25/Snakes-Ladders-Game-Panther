package model;

import java.util.HashMap;

public class Game {
	private static int gameNum=0;
	private HashMap<Integer,Player> allPlayers; // the participants in the game 
	private HashMap<Integer,ladder> allLaders; // the ladders among the game
	private HashMap<Integer,Snake> allSankes; // the snakes among the game 
	private Dice dice;
	private int gameLevel; //game level , 1 -easy , 2 medium , 3 hard
	// timer 1  from the start to the finish 
	// timer 2  for each player how long does it take for each turn 
	 private Player currplayer;
	 
	 	
	
	

}