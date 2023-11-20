package com.lithan.jumpstart.exception;

public class OutOfProductStockException extends RuntimeException {
    public OutOfProductStockException(String message) {
        super(message);
    }
}
