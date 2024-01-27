package model;

public class Snake {
	private static int snakeNumber=1;
	private int squareStart;
	private int squareEnd;
	//private String snakeColor;
	public Snake(int squareStart, int squareEnd) {
		this.squareStart = squareStart;
		this.squareEnd = squareEnd;
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
	@Override
	public String toString() {
		return "Snake [squareStart=" + squareStart + ", squareEnd=" + squareEnd + "]";
	}
	
	

}