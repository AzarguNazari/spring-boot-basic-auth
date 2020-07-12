package com.springboot.exercise.web.error;

public class UserNotFoundException extends RuntimeException{

    private final static long serialVersionUID = 5861310537366287163L;

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final Throwable cause) {
        super(cause);
    }
}
