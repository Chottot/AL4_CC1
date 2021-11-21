package com.chottot.member;

final public class PasswordCredential extends Credential
{
    private final String password;

    public PasswordCredential(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
