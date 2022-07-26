package com.lirik.exception;

public class StoreRuntimeException extends RuntimeException {
    public StoreRuntimeException() {
    }

    public StoreRuntimeException(String message) {
        super(message);
    }
}
