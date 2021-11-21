package com.chottot.member;

public interface ICredentialValidator<T extends Credential> {
    boolean isValid(T credential);
}
