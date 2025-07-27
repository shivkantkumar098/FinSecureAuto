package org.FinsecureAuto.constant;

public final class ErrorMessages {
    public static final String INVALID_BROWSER_TYPE = "Invalid browser type: ";
    public static final String DRIVER_NOT_FOUND = "Driver not found for the specified browser type.";
    public static final String DRIVER_CREATION_FAILED = "Failed to create driver instance.";
    public static final String INVALID_URL = "The provided URL is invalid.";
    public static final String ELEMENT_NOT_FOUND = "The specified element could not be found.";
    public static final String TIMEOUT_EXCEEDED = "The operation timed out.";

    private ErrorMessages() {
        // Private constructor to prevent instantiation
    }
}
