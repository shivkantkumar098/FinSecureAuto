package org.FinsecureAuto.customException;

public class FrameWork extends RuntimeException{
    public FrameWork(String message) {
        super(message);
    }

    public FrameWork(String message, Throwable cause) {
        super(message, cause);
    }
}
