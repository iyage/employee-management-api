package com.example.demo.exceptions;

public class ResourceNotFoundExption extends RuntimeException{
    public ResourceNotFoundExption(String message) {
        super(message);
    }
}
