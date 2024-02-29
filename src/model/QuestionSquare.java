
package model;

public class QuestionSquare extends Square{
	String type;
	public QuestionSquare(String type,int xCoordinate, int yCoordinate) {
		super(xCoordinate, yCoordinate);
		this.type=type;
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
			
}