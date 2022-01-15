package com.chottot.trademe.domain.credential;

public class CredentialWrongTypeException extends CredentialException {
    public CredentialWrongTypeException() {
        super("Credential mismatch ");
    }
}
