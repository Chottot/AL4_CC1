package com.chottot.member;

import com.chottot.email.EmailAddress;

import java.time.LocalDate;

final public class Member {

    private String firstName;
    private String lastName;
    private PasswordCredential credential;
    private EmailAddress emailAddress;
    private LocalDate birthDate;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PasswordCredential getCredential() {
        return credential;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }
}
