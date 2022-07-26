package com.lirik.exception;

public class DuplicatedException extends StoreException {
    public DuplicatedException() {
    }

    public DuplicatedException(String message) {
        super(message);
    }
}
