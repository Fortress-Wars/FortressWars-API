package net.fortresswars.core.validators;

public class MaximumValidator implements DataValidator {

    private final double max;

    public MaximumValidator(double max) {
        this.max = max;
    }

    @Override
    public void validate(double value) throws DataValidationException {
        if (value > max) {
            throw new DataValidationException("value must be less than or equal to " + max);
        }
    }
}
