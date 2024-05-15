package com.ac.simulator.exceptions;

public abstract class ApplicationException extends Throwable {
    public abstract String getErrorName();

    public abstract String getErrorDescription();
}
