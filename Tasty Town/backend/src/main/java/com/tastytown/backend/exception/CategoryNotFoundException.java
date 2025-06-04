package com.tastytown.backend.exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException() {
        super();
    }

    public CategoryNotFoundException(String msg)  {
        super(msg);
    }
}
