package com.ac.simulator.exceptions;

public class InvalidFileException extends ApplicationException {

    public static final String ERROR_NAME = "INVALID_FILE";
    public static final String ERROR_DESCRIPTION = "Unable to load file";

    @Override
    public String getErrorName() {
        return ERROR_NAME;
    }

    @Override
    public String getErrorDescription() {
        return ERROR_DESCRIPTION;
    }
}
