package org.FinsecureAuto.customException;

public class FAILEDToLoadPropertiesFileException extends RuntimeException {
    public FAILEDToLoadPropertiesFileException(String message) {
        super(message);
    }

    public FAILEDToLoadPropertiesFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
