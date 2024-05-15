package com.ac.simulator.exceptions;

public class ReservedTreeClearingException extends ApplicationException {

    public static final String ERROR_NAME = "RESERVED_TREE_CLEARING";
    public static final String ERROR_DESCRIPTION = "Clearing of reserved tree is not allowed";

    @Override
    public String getErrorName() {
        return ERROR_NAME;
    }

    @Override
    public String getErrorDescription() {
        return ERROR_DESCRIPTION;
    }
}
