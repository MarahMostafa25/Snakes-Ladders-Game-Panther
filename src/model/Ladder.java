package model;

import utils.Level;

public class Ladder {
	private static  int ladderId=0;
	private int LadderNum;
	private Square squareStart;
	private Square squareEnd;
	private int squareLenght;
	private Level levelGame;
	public Ladder(int ladderId,Square squareStart, Square squareEnd,int squareLenght,Level levelGame) {
        this.LadderNum=ladderId++;
		this.squareStart = squareStart;
		this.squareEnd = squareEnd;
		this.levelGame=levelGame;
		if(levelGame.equals(Level.Easy))
		{
			if(squareLenght>4) {
				this.squareLenght=4;
			}
			else if(squareLenght<1) {
				this.squareLenght=1;
			}
			else {
				this.squareLenght=squareLenght;

			}
		}
		
		if(levelGame.equals(Level.Medium))
		{
			if(squareLenght>6) {
				this.squareLenght=6;
			}
			else if(squareLenght<1) {
				this.squareLenght=1;
			}
			else {
				this.squareLenght=squareLenght;

			}
		}
		
		if(levelGame.equals(Level.Hard))
		{
			if(squareLenght>8) {
				this.squareLenght=8;
			}
			else if(squareLenght<1) {
				this.squareLenght=1;
			}
			else {
				this.squareLenght=squareLenght;

			}
		}
	
	
	
	}
	public static int getLadderId() {
		return ladderId;
	}
	public static void setLadderId(int ladderId) {
		Ladder.ladderId = ladderId;
	}
	public Square getSquareStart() {
		return squareStart;
	}
	
	public int getSquareLenght() {
		return squareLenght;
	}
	public void setSquareLenght(int squareLenght) {
		this.squareLenght = squareLenght;
	}
	public void setSquareStart(Square squareStart) {
		this.squareStart = squareStart;
	}
	public Square getSquareEnd() {
		return squareEnd;
	}
	public void setSquareEnd(Square squareEnd) {
		this.squareEnd = squareEnd;
	}
	@Override
	public String toString() {
		return "Ladder [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public int getLadderNum() {
		return LadderNum;
	}
	public void setLadderNum(int ladderNum) {
		LadderNum = ladderNum;
	}
	public Level getLevelGame() {
		return levelGame;
	}
	public void setLevelGame(Level levelGame) {
		this.levelGame = levelGame;
	}
	
	
	
	
	
	
	

}