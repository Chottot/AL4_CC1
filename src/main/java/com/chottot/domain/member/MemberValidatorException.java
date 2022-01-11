package com.chottot.domain.member;

import com.chottot.domain.credential.Credential;

public class MemberValidatorException extends RuntimeException{
    public MemberValidatorException(String message) {
        super(message);
    }
}

class MemberTooYoungException extends MemberValidatorException{
    public MemberTooYoungException(int ageMin) {
        super("You need to be a least "+ageMin+" year old");
    }
}

class MemberValidatorNoCredentialValidatorException extends MemberValidatorException{
    public MemberValidatorNoCredentialValidatorException(Credential credential) {
        super("There is no credential validator for " + credential.getClass().getSimpleName());
    }
}