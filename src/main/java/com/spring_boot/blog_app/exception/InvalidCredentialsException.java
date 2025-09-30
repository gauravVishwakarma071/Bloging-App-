package com.spring_boot.blog_app.exception;

public class InvalidCredentialsException extends IllegalArgumentException {
    public InvalidCredentialsException() {
        super("Invalid username or password combination");
    }
}
