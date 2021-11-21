package com.chottot.service;

import com.chottot.email.EmailAddress;
import com.chottot.email.IEmailValidatorService;

public class EmailValidatorService implements IEmailValidatorService {

    @Override
    public boolean isEmailAddressValid(EmailAddress emailAddress) {
        return false;
    }

}
