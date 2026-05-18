package net.fortresswars.core.validators;

public class MinimumValidator implements DataValidator {

    private final double min;

    public MinimumValidator(double min) {
        this.min = min;
    }

    @Override
    public void validate(double value) throws DataValidationException {
        if (value < min) {
            throw new DataValidationException("value must be greater than or equal to " + min);
        }
    }
}
