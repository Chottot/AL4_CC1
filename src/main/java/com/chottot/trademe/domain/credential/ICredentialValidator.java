package com.chottot.trademe.domain.credential;

public interface ICredentialValidator {

    boolean canCredentialBeValida(Credential credential);
    boolean validate(Credential credential);

}
