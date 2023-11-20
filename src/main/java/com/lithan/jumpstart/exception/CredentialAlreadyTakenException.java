package com.lithan.jumpstart.exception;

public class CredentialAlreadyTakenException extends RuntimeException {
    public CredentialAlreadyTakenException(String message) {
        super(message);
    }
}
