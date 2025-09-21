package com.spring_boot.blog_app.exception;

public class UserNotFoundException extends IllegalArgumentException {
    public UserNotFoundException(String username) {
        super("User with username '" + username + "' not found");
    }

    public UserNotFoundException(Long userId) {
        super("User with ID " + userId + " not found");
    }
}


