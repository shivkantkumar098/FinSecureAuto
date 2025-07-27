package org.FinsecureAuto.customException;

public class BrowserNotSupported  extends RuntimeException{
    public BrowserNotSupported(String message){
        super(message);
    }
    public BrowserNotSupported(String message ,Throwable cause){
        super(message, cause);
    }
}
