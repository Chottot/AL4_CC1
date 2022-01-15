package com.chottot.trademe.domain.service;

import com.chottot.trademe.domain.email.EmailAddress;
import com.chottot.trademe.domain.email.IEmailValidatorService;

public class EmailValidatorService implements IEmailValidatorService {

    @Override
    public boolean isEmailAddressValid(EmailAddress emailAddress) {
        return true;
    }

}
