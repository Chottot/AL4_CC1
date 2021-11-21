package com.chottot.member;

public class PasswordValidator implements  ICredentialValidator<PasswordCredential>{

    @Override
    public boolean isValid(PasswordCredential credential) {
        return false;
    }

}
