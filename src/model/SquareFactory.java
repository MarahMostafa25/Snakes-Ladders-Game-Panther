package model;

public class SquareFactory {
	
	public Square getType(String type,int xCoordinate, int yCoordinate) {
		if(type.equals("SurpriseSquare")) {
			return new SurpriseSquare(xCoordinate,yCoordinate);
		}
		if(type.equals("Hard")) {
			return new QuestionSquare(type,xCoordinate,yCoordinate);
		}
		
		if(type.equals("Easy")) {
			return new QuestionSquare(type,xCoordinate,yCoordinate);
		}
		
		if(type.equals("Medium")) {
			return new QuestionSquare(type,xCoordinate,yCoordinate);
		}
		return null;
		
	}

}
