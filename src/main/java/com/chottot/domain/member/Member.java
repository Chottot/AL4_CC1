package com.chottot.domain.member;

import com.chottot.domain.credential.LoginPasswordCredential;
import com.chottot.domain.email.EmailAddress;

import java.time.LocalDate;

final public class Member {

    public final static int MEMBER_AGE_MIN = 18;

    private final String firstName;
    private final String lastName;
    private final LoginPasswordCredential credential;
    private final EmailAddress emailAddress;
    private final LocalDate birthDate;

    private Member(String firstName, String lastName, LoginPasswordCredential credential, EmailAddress emailAddress, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credential = credential;
        this.emailAddress = emailAddress;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LoginPasswordCredential getCredential() {
        return credential;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }


    public Member createMember(String firstName, String lastName, String password, String emailAddress, LocalDate birthDate) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Your first name can't be empty");
        }

        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Your last name can't be empty");
        }

        EmailAddress email = EmailAddress.createEmailAddress(emailAddress);

        LoginPasswordCredential credential = LoginPasswordCredential.createLoginPasswordCredentialWithEmailAddress(email, password);

        return new Member(firstName, lastName, credential, email, birthDate);
    }


}
