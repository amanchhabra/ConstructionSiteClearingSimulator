package com.ac.simulator.exceptions;

public class InvalidSitemapException extends ApplicationException {

    public static final String ERROR_NAME = "INVALID_SITEMAP";
    public static final String ERROR_DESCRIPTION = "Unable to load Sitemap file";

    @Override
    public String getErrorName() {
        return ERROR_NAME;
    }

    @Override
    public String getErrorDescription() {
        return ERROR_DESCRIPTION;
    }
}
