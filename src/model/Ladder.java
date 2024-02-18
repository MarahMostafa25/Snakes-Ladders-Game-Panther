package model;

import utils.Level;

public class Ladder {
	private static  int ladderId=0;
	private int LadderNum;
	private int squareStart;
	private int squareEnd;
	private int LadderLenght;
	private Level levelGame;
	public Ladder(int ladderId,int squareStart, int squareEnd,int LadderLenght,Level levelGame) {
        this.LadderNum=ladderId++;
		this.squareStart = squareStart;
		this.squareEnd = squareEnd;
		this.levelGame=levelGame;
		if(levelGame.equals(Level.Easy))
		{
			if(LadderLenght>4) {
				this.LadderLenght=4;
			}
			else if(LadderLenght<1) {
				this.LadderLenght=1;
			}
			else {
				this.LadderLenght=LadderLenght;

			}
		}
		
		if(levelGame.equals(Level.Medium))
		{
			if(LadderLenght>6) {
				this.LadderLenght=6;
			}
			else if(LadderLenght<1) {
				this.LadderLenght=1;
			}
			else {
				this.LadderLenght=LadderLenght;

			}
		}
		
		if(levelGame.equals(Level.Hard))
		{
			if(LadderLenght>8) {
				this.LadderLenght=8;
			}
			else if(LadderLenght<1) {
				this.LadderLenght=1;
			}
			else {
				this.LadderLenght=LadderLenght;

			}
		}
	
	
	
	}
	public static int getLadderId() {
		return ladderId;
	}
	public static void setLadderId(int ladderId) {
		Ladder.ladderId = ladderId;
	}
	public int getLadderNum() {
		return LadderNum;
	}
	public void setLadderNum(int ladderNum) {
		LadderNum = ladderNum;
	}
	public int getSquareStart() {
		return squareStart;
	}
	public void setSquareStart(int squareStart) {
		this.squareStart = squareStart;
	}
	public int getSquareEnd() {
		return squareEnd;
	}
	public void setSquareEnd(int squareEnd) {
		this.squareEnd = squareEnd;
	}
	public int getLadderLenght() {
		return LadderLenght;
	}
	public void setLadderLenght(int ladderLenght) {
		LadderLenght = ladderLenght;
	}
	public Level getLevelGame() {
		return levelGame;
	}
	public void setLevelGame(Level levelGame) {
		this.levelGame = levelGame;
	}
	
	
	

}