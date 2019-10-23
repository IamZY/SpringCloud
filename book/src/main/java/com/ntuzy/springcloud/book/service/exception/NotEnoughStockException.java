package com.ntuzy.springcloud.book.service.exception;

public class NotEnoughStockException extends RuntimeException {
    public NotEnoughStockException(String msg) {
        super(msg);
    }
}
