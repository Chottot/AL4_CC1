package com.chottot.domain.credential.LoginPassword;

import com.chottot.domain.credential.*;

public class LoginPasswordValidator implements ICredentialValidator {

    private final int lengthMin;
    private final int lengthMax;

    public LoginPasswordValidator(int lengthMin, int lengthMax) {
        this.lengthMin = lengthMin;
        this.lengthMax = lengthMax;
    }

    @Override
    public boolean canCredentialBeValida(Credential credential) {
        if (credential == null) throw new CredentialNullException();
        if (!(credential instanceof LoginPasswordCredential)) throw new CredentialWrongTypeException();
        return true;
    }

    public boolean validate(Credential credential) {
        canCredentialBeValida(credential);

        LoginPasswordCredential loginPasswordCredential = (LoginPasswordCredential) credential;

        if (loginPasswordCredential.getLogin() == null || loginPasswordCredential.getLogin().isEmpty())
            throw new LoginPasswordEmptyLoginException();
        if (loginPasswordCredential.getPassword() == null || loginPasswordCredential.getPassword().length() < lengthMin || loginPasswordCredential.getPassword().length() > lengthMax)
            throw new LoginPasswordSizePasswordException(lengthMin, lengthMax);
        return true;
    }
}
