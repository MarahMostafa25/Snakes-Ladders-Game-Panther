package model;

import utils.SnakeColor;

public class Snake {
	private static int snakeNumber=1;
	private Square squareStart;
	private Square squareEnd;
	private SnakeColor snakeColor;
	private int snakeId;
	
	public Snake(Square squareStart, Square squareEnd,SnakeColor snakeColor) {
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
	public Square getSquareStart() {
		return squareStart;
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