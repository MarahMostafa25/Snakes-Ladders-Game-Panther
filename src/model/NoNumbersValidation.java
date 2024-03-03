package model;

public class NoNumbersValidation implements ValidationStrategy{

	public NoNumbersValidation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate(String input) {
		return input.chars().allMatch(Character::isLetter) && !input.trim().isEmpty();
		
	}

}
