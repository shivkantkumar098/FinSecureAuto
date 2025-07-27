package org.FinsecureAuto.customException;

public class DriverInitilization extends RuntimeException{
    public DriverInitilization(String message) {
        super(message);
    }

    public DriverInitilization(String message, Throwable cause) {
        super(message, cause);
    }
}
