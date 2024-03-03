package model;

public class InputValidator {
    private ValidationStrategy validationStrategy;

    public InputValidator(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean validateInput(String input) {
        return validationStrategy.validate(input);
    }
}
