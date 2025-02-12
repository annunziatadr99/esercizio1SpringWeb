package com.demo.esercizio1SpringWeb.exception;
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(int id) {
        super(id + " non trovato!");
    }
}
