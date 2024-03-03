package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


import utils.Level;

public class Game implements Serializable{
	private static int gameNum=0;
	private Level gameLevel; //game level , 1 -easy , 2 medium , 3 hard
	private Player winner;
	private String gameTimer;
	private int id;
	public Game(Level gameLevel , Player winner ,String gameTimer) {
		super();
		id=gameNum++;
		this.gameLevel = gameLevel;
		this.winner = winner;
		this.gameTimer = gameTimer;
	}
	public static int getGameNum() {
		return gameNum;
	}
	public static void setGameNum(int gameNum) {
		Game.gameNum = gameNum;
	}
	public Level getGameLevel() {
		return gameLevel;
	}
	public void setGameLevel(Level gameLevel) {
		this.gameLevel = gameLevel;
	}
	public Player getWinner() {
		return winner;
	}
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	public String getGameTimer() {
		return gameTimer;
	}
	public void setGameTimer(String gameTimer) {
		this.gameTimer = gameTimer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Game [gameLevel=" + gameLevel + ", winner=" + winner + ", gameTimer=" + gameTimer + ", id=" + id + "]";
	}
	

	

	
}