package com.ac.simulator.exceptions;

public class InvalidArgumentException extends ApplicationException {

    public static final String ERROR_NAME = "INVALID_ARGUMENT";
    public static final String ERROR_DESCRIPTION = "Expected Sitemap argument in command";

    @Override
    public String getErrorName() {
        return ERROR_NAME;
    }

    @Override
    public String getErrorDescription() {
        return ERROR_DESCRIPTION;
    }
}
