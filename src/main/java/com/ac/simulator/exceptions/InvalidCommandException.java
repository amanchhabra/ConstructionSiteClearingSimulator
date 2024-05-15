package com.ac.simulator.exceptions;

public class InvalidCommandException extends ApplicationException {

    public static final String ERROR_NAME = "INVALID_COMMAND";
    public static final String ERROR_DESCRIPTION = "Invalid command or command not supported";

    @Override
    public String getErrorName() {
        return ERROR_NAME;
    }

    @Override
    public String getErrorDescription() {
        return ERROR_DESCRIPTION;
    }
}
