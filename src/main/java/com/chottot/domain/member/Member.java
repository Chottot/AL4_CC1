package com.chottot.domain.member;

import com.chottot.core.IEntity;
import com.chottot.domain.credential.Credential;
import com.chottot.domain.email.EmailAddress;

import java.time.LocalDate;

final public class Member implements IEntity<MemberID> {

    private final MemberID id;
    private final String firstName;
    private final String lastName;
    private final Credential credential;
    private final LocalDate birthDate;

    public Member(String firstName, String lastName, Credential credential, EmailAddress emailAddress, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credential = credential;
        this.id = new MemberID(emailAddress);
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Credential getCredential() {
        return credential;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public EmailAddress getEmailAddress() {
        return id.getValue();
    }

    @Override
    public MemberID getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
