package com.chottot.domain.service;

import com.chottot.domain.email.EmailAddress;
import com.chottot.domain.email.IEmailValidatorService;

public class EmailValidatorService implements IEmailValidatorService {

    @Override
    public boolean isEmailAddressValid(EmailAddress emailAddress) {
        return false;
    }

}
