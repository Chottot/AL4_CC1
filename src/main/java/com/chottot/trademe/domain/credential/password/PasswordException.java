package com.chottot.trademe.domain.credential.password;

public class PasswordException extends RuntimeException {
    public PasswordException(String message) {
        super(message);
    }
}

class PasswordSizePasswordException extends PasswordException {
    public PasswordSizePasswordException(int min, int max) {
        super("Your password need to be between " + min + " and " + max + " long");
    }
}


