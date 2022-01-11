package com.chottot.domain.credential;

public class CredentialNullException extends CredentialException {
    public CredentialNullException() {
        super("Your credentials are null");
    }
}
