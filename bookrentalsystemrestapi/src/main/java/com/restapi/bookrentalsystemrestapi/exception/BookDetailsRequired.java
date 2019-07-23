package com.restapi.bookrentalsystemrestapi.exception;

public class BookDetailsRequired extends RuntimeException {
    public BookDetailsRequired(String message)
    {
        super(message);
    }
}
