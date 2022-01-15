package com.chottot.trademe.domain.credential.password;

import com.chottot.trademe.domain.credential.*;

public class PasswordValidator implements ICredentialValidator {

    private final int lengthMin;
    private final int lengthMax;

    public PasswordValidator(int lengthMin, int lengthMax) {
        this.lengthMin = lengthMin;
        this.lengthMax = lengthMax;
    }

    @Override
    public boolean canCredentialBeValidate(Credential credential) {
        if (credential == null) throw new IllegalArgumentException("credential is null");
        return credential instanceof PasswordCredential;
    }

    public boolean validate(Credential credential) {
        if (!canCredentialBeValidate(credential)) {
            throw new CredentialWrongTypeException();
        }

        PasswordCredential passwordCredential = (PasswordCredential) credential;

        if (passwordCredential.getPassword() == null || passwordCredential.getPassword().length() < lengthMin || passwordCredential.getPassword().length() > lengthMax)
            throw new PasswordSizePasswordException(lengthMin, lengthMax);
        return true;
    }
}
