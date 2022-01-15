package com.chottot.trademe.domain.service.email;

import com.chottot.trademe.domain.email.EmailAddress;
import com.chottot.trademe.domain.email.IEmailValidatorService;
import com.chottot.trademe.domain.service.email.InvalidEmailException;

public class EmailValidatorService implements IEmailValidatorService {

    @Override
    public boolean validate(EmailAddress emailAddress) {
        if(emailAddress == null) throw new IllegalArgumentException("email address is null");
        if(emailAddress.getEmail() == null ||emailAddress.getEmail().isEmpty()) throw new InvalidEmailException();
        return true;
    }

}
