package net.fortresswars.core.validators;

public interface DataValidator {

    /**
     * Validate a value
     * @param value the value
     */
    void validate(double value) throws DataValidationException;
}
