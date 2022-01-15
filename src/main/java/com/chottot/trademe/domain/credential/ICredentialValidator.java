package com.chottot.trademe.domain.credential;

public interface ICredentialValidator {

    boolean canCredentialBeValidate(Credential credential);
    boolean validate(Credential credential);

}
