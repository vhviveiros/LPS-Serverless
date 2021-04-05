package com.etc.exception.invalid_input_exception;

public abstract class InvalidNameInputException extends InvalidInputException {
    public InvalidNameInputException(String message) {
        super(message);
    }

    public static class LongNameException extends InvalidNameInputException {
        public LongNameException() {
            super("O nome informado é muito longo!");
        }
    }

    public static class ShortNameException extends InvalidNameInputException {
        public ShortNameException() {
            super("O nome informado é muito curto!");
        }
    }

    public static class InvalidCharactersException extends InvalidNameInputException {
        public InvalidCharactersException() {
            super("O nome informado possui caracteres inválidos! Utilize apenas letras e números!");
        }
    }
}
