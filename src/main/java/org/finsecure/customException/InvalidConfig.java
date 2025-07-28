package org.finsecure.customException;

public class InvalidConfig extends RuntimeException{
    public InvalidConfig(String message) {
        super(message);
    }

    public InvalidConfig(String message, Throwable cause) {
        super(message, cause);
    }
}
