package com.validation;

import com.controller.ControllerSingleton;
import com.etc.exception.invalid_input_exception.*;

import java.util.Date;

public class SupplyValidation extends Validation {
    private final String name;
    private final String details;
    private final String amount;
    private final String expirationDate;
    private final String price;

    public SupplyValidation(String[] args) {
        name = args[0];
        details = args[1];
        amount = args[2];
        expirationDate = args[3];
        price = args[4];
    }

    public String nameValidation() throws InvalidNameInputException {
        if (ControllerSingleton.SUPPLY_CONTROLLER.getItem(new String[]{name}) != null)
            throw new ExistingUserException();

        return super.nameValidation(name);
    }

    public String detailsValidation() {
        return details;
    }

    public double amountValidation() throws InvalidQuantityException {
        try {
            double qtd = Double.parseDouble(amount);

            if (qtd < 1)
                throw new InvalidQuantityException();

            return qtd;
        } catch (NumberFormatException e) {
            throw new InvalidQuantityException();
        }
    }

    public Date expirationDateValidation() throws InvalidDateException {
        return super.nextDateValidation(expirationDate);
    }

    public double priceValidation() throws InvalidPriceException {
        return super.priceValidation(this.price);
    }
}
