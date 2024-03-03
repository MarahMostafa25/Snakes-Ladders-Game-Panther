package model;

public class NonEmptyValidation implements ValidationStrategy{

	public NonEmptyValidation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate(String input) {
		return !input.isEmpty();
		
	}

}
