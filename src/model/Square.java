
package model;

public class Square {
	private static int idCounter = 1;
	private Integer id;
	private int xCoordinate;
	private int yCoordinate;
	public Square(int xCoordinate, int yCoordinate) {
		super();
		this.id=idCounter++;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public int getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	@Override
	public String toString() {
		return "Square [id=" + id + ", xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + "]";
	}
	
	

	

}