package net.fortresswars.core.validators;

public class NonZeroValidator implements DataValidator {

    @Override
    public void validate(double value) throws DataValidationException {
        if (value == 0) {
            throw new DataValidationException("value must be non-zero");
        }
    }
}
