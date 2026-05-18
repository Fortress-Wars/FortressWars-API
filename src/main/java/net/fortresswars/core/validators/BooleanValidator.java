package net.fortresswars.core.validators;

public class BooleanValidator implements DataValidator {

    @Override
    public void validate(double value) throws DataValidationException {
        if (value != 0 && value != 1) {
            throw new DataValidationException("value must be a boolean");
        }
    }
}
