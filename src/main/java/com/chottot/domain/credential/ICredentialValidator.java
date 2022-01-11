package com.chottot.domain.credential;

public interface ICredentialValidator {

    boolean canCredentialBeValida(Credential credential);
    boolean validate(Credential credential);

}
