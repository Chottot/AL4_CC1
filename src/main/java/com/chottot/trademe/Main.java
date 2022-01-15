package com.chottot.trademe;

import com.chottot.trademe.domain.credential.ICredentialValidator;
import com.chottot.trademe.domain.credential.LoginPassword.LoginPasswordCredential;
import com.chottot.trademe.domain.credential.LoginPassword.LoginPasswordValidator;
import com.chottot.trademe.domain.email.EmailAddress;
import com.chottot.trademe.domain.member.Member;
import com.chottot.trademe.domain.member.MemberID;
import com.chottot.trademe.domain.member.MemberValidator;
import com.chottot.trademe.domain.repository.MemberMemoryRepository;
import com.chottot.trademe.domain.service.EmailValidatorService;
import com.chottot.trademe.domain.service.MemberService;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String email = "chottot@myges.fr";
        Member member = new Member("clement", "HOTTOT", new LoginPasswordCredential("test", "12345697"), new EmailAddress(email), LocalDate.of(1999, 8, 21));

        //MemberValidator memberValidator = new MemberValidator(18, new LoginPasswordValidator(7, 20), new EmailValidatorService());

        ArrayList<ICredentialValidator> validators = new ArrayList<>();
        validators.add(new LoginPasswordValidator(7, 20));

        MemberValidator memberValidator = MemberValidator.createMemberValidatorWithCurrentDate(LocalDate.now(), 18, validators, new EmailValidatorService());

        MemberService service = new MemberService(new MemberMemoryRepository(), memberValidator);

        service.register(member);
        service.getByID(new MemberID(new EmailAddress(email)));

        System.out.println("test: " + service.getByID(member.getID()));

    }
}
