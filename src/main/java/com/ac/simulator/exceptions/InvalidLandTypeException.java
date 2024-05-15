package com.ac.simulator.exceptions;

public class InvalidLandTypeException extends ApplicationException {

    public static final String ERROR_NAME = "INVALID_LAND_TYPE";
    public static final String ERROR_DESCRIPTION = "Land Type is not valid";

    @Override
    public String getErrorName() {
        return ERROR_NAME;
    }

    @Override
    public String getErrorDescription() {
        return ERROR_DESCRIPTION;
    }
}
