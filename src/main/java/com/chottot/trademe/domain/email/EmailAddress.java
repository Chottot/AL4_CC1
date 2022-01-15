package com.chottot.trademe.domain.email;

import com.chottot.trademe.domain.service.EmailValidatorService;

import java.util.Objects;

final public class EmailAddress {

    private static final IEmailValidatorService defaultEmailValidatorService = new EmailValidatorService();

    private final String email;

    public EmailAddress(String email) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddress that = (EmailAddress) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return email;
    }
}
