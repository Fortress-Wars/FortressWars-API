package net.fortresswars.core.validators;

public class IntegerValidator implements DataValidator {

    @Override
    public void validate(double value) throws DataValidationException {
        if (value % 1 != 0) {
            throw new DataValidationException("value must be an integer");
        }
    }
}
