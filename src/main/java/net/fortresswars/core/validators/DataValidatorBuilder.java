package net.fortresswars.core.validators;

import java.util.LinkedList;
import java.util.List;

public class DataValidatorBuilder {

    final List<DataValidator> validators;

    public static DataValidatorBuilder create() {
        return new DataValidatorBuilder();
    }

    private DataValidatorBuilder() {
        this.validators = new LinkedList<>();
    }

    /**
     * Adds non-zero validation. Value must not be zero
     * @return the KitDataValidatorBuilder instance
     */
    public DataValidatorBuilder nonZero() {
        validators.add(new NonZeroValidator());
        return this;
    }

    /**
     * Adds integer validation
     * @return the KitDataValidatorBuilder instance
     */
    public DataValidatorBuilder integer() {
        validators.add(new IntegerValidator());
        return this;
    }

    /**
     * Adds boolean validation (0 or 1)
     * @return the KitDataValidatorBuilder instance
     */
    public DataValidatorBuilder bool() {
        validators.add(new BooleanValidator());
        return this;
    }

    /**
     * Adds value max validation. Value must greater than or equal to this value
     * @param min the minimum value
     * @return the KitDataValidatorBuilder instance
     */
    public DataValidatorBuilder min(double min) {
        validators.add(new MinimumValidator(min));
        return this;
    }

    /**
     * Adds value max validation. Value must less than or equal to this value
     * @param max the maximum value
     * @return the KitDataValidatorBuilder instance
     */
    public DataValidatorBuilder max(double max) {
        validators.add(new MaximumValidator(max));
        return this;
    }

    /**
     * Adds a min and max validator.
     * @param min the minimum value
     * @param max the maximum value
     * @return the KitDataValidatorBuilder instance
     */
    public DataValidatorBuilder range(double min, double max) {
        return this.min(min).max(max);
    }

    /**
     * Adds a factor validator. The checked value must be a factor of the product.
     * @param product the number that is used to check if a value is a factor (no remainder when dividing)
     * @return the KitDataValidatorBuilder instance
     */
    public DataValidatorBuilder factorOf(double product) {
        validators.add(new FactorOfValidator(product));
        return this;
    }

    /**
     * Build a new combined validator.
     * @return KitDataValidator
     */
    public DataValidator build() {
        return value -> {
            for (DataValidator validator: validators) {
                validator.validate(value);
            }
        };
    }
}
