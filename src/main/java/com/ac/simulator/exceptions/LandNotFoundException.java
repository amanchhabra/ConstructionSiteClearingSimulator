package com.ac.simulator.exceptions;

public class LandNotFoundException extends ApplicationException {
    public static final String ERROR_NAME = "LAND_NOT_FOUND_EXCEPTION";
    public static final String ERROR_DESCRIPTION = "Requested Land Not Found";

    @Override
    public String getErrorName() {
        return ERROR_NAME;
    }

    @Override
    public String getErrorDescription() {
        return ERROR_DESCRIPTION;
    }
}
