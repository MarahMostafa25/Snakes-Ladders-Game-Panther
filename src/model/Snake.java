package model;

import utils.SnakeColor;

public class Snake {
	private static int snakeNumber=1;
	private int squareStart;
	private int squareEnd;
	private SnakeColor snakeColor;
	private int snakeId;
	
	public Snake(int squareStart, int squareEnd,SnakeColor snakeColor) {
		this.squareStart = squareStart;
		this.squareEnd = squareEnd;
		this.snakeColor=snakeColor;
		this.snakeId=snakeNumber++;
	
	}
	public static int getSnakeNumber() {
		return snakeNumber;
	}
	public static void setSnakeNumber(int snakeNumber) {
		Snake.snakeNumber = snakeNumber;
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
	public SnakeColor getSnakeColor() {
		return snakeColor;
	}
	public void setSnakeColor(SnakeColor snakeColor) {
		this.snakeColor = snakeColor;
	}
	@Override
	public String toString() {
		return "Snake [squareStart=" + squareStart + ", squareEnd=" + squareEnd + ", snakeColor=" + snakeColor + "]";
	}

	
	
	

}