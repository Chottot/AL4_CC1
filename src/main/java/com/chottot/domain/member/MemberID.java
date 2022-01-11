package com.chottot.domain.member;

import com.chottot.domain.email.EmailAddress;

import java.util.Objects;

public class MemberID {

    private final EmailAddress value;

    public MemberID(EmailAddress value) {
        this.value = value;
    }

    public EmailAddress getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MemberID userId = (MemberID) obj;
        boolean test = value.equals(userId.value);
        return test;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MemberID{" +
                "email = " + value +
                '}';
    }
}
