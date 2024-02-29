
package model;

public class QuestionSquare extends Square{
	String type;
	Question q;
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
	public Question getQ() {
		return q;
	}
	public void setQ(Question q) {
		this.q = q;
	}
	
	
			
}