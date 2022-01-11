package com.chottot.domain.credential.LoginPassword;

public class LoginPasswordException extends RuntimeException {
    public LoginPasswordException(String message) {
        super(message);
    }
}

class LoginPasswordEmptyLoginException extends LoginPasswordException {
    public LoginPasswordEmptyLoginException() {
        super("Your login can't be empty");
    }
}

class LoginPasswordSizePasswordException extends LoginPasswordException {
    public LoginPasswordSizePasswordException(int min, int max) {
        super("Your password need to be between " + min + " and " + max + " long");
    }
}


