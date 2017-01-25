package com.gramazski.handling.exception;

/**
 * Created by gs on 25.01.2017.
 */
public class KeyNotFoundException extends Exception {
    public KeyNotFoundException() {
    }

    public KeyNotFoundException(String message, Throwable exception) {
        super(message, exception);
    }

    public KeyNotFoundException(String message) {
        super(message);
    }

    public KeyNotFoundException(Throwable exception) {
        super(exception);
    }
}
