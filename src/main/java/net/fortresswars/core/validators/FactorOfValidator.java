package net.fortresswars.core.validators;

public class FactorOfValidator implements DataValidator {

    private final double product;

    public FactorOfValidator(double product) {
        this.product = product;
    }

    @Override
    public void validate(double value) throws DataValidationException {
        if (value == 0) {
            throw new DataValidationException("value must be non-zero");
        }
        if (product % value != 0) {
            throw new DataValidationException("value must be a factor of " + product);
        }
    }
}
