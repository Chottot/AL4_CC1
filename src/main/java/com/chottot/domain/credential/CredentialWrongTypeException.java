package com.chottot.domain.credential;

public class CredentialWrongTypeException extends CredentialException {
    public CredentialWrongTypeException() {
        super("Credential mismatch ");
    }
}
