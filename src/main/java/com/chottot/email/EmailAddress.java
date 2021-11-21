package com.chottot.email;

import com.chottot.service.EmailValidatorService;

final public class EmailAddress {

    private static final IEmailValidatorService defaultEmailValidatorService = new EmailValidatorService();

    private final String email;

    private EmailAddress(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public static EmailAddress createEmailAddress(String email, IEmailValidatorService validator)
    {
        EmailAddress emailAddress = new EmailAddress(email);

        if(validator.isEmailAddressValid(emailAddress)){
            return emailAddress;
        }else{
            throw new InvalidEmailException();
        }
    }

    public static EmailAddress createEmailAddress(String email)
    {
       return createEmailAddress(email, defaultEmailValidatorService);
    }
}
