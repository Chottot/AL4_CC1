package com.chottot.trademe.domain.credential.password;

import com.chottot.trademe.domain.credential.Credential;
import com.chottot.trademe.domain.email.EmailAddress;

final public class PasswordCredential extends Credential {

    private final String password;

    public PasswordCredential( String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
