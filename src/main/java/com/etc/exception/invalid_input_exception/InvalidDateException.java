package com.etc.exception.invalid_input_exception;

public class InvalidDateException extends InvalidInputException{
    public InvalidDateException() {
        super("A data informada é inválida!");
    }
}
