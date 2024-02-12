package model;

import utils.Level;

public class HelpClass {
	
	
	  
	  private final static  HelpClass in = new HelpClass();
	  private Player p1;
	  private Player p2;
	  private Player p3;
	  private Player p4;
	  private Level levelGame;
	  private int numOfPlayer;
	  
	  public int getNumOfPlayer() {
		return numOfPlayer;
	}

	public void setNumOfPlayer(int numOfPlayer) {
		this.numOfPlayer = numOfPlayer;
	}

	/*
	   * this class helps me save the current players and level in order to use it 
	   * in the game .
	   */
	  private HelpClass() {}
	  
	  public static HelpClass getInstance() {
	    return in;
	  }
	  
	public Player getP1() {
		return p1;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	public Player getP3() {
		return p3;
	}

	public void setP3(Player p3) {
		this.p3 = p3;
	}

	public Player getP4() {
		return p4;
	}

	public void setP4(Player p4) {
		this.p4 = p4;
	}

	public Level getLevelGame() {
		return levelGame;
	}

	public void setLevelGame(Level levelGame) {
		this.levelGame = levelGame;
	}
	  

	

}
