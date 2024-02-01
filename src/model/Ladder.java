package model;

public class Ladder {
	private static  int ladderId=0;
	private Square squareStart;
	private Square squareEnd;
	private int squareLenght;
	public Ladder(int ladderId,Square squareStart, Square squareEnd,int squareLenght) {
		super();
		ladderId++;
		this.squareStart = squareStart;
		this.squareEnd = squareEnd;
		this.squareLenght = squareLenght;
	
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
	
	
	
	

}