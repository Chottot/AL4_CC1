package com.chottot.domain.service;

import com.chottot.domain.email.EmailAddress;
import com.chottot.domain.email.IEmailValidatorService;
import com.chottot.domain.member.Member;
import com.chottot.domain.credential.LoginPasswordValidator;
import com.chottot.domain.repository.MemberRepository;

public class MemberService{

    MemberRepository memberRepository;
    IEmailValidatorService emailValidatorService;
    LoginPasswordValidator credentialValidator;

    public MemberService(MemberRepository memberRepository, IEmailValidatorService emailValidatorService, LoginPasswordValidator credentialValidator) {
        this.memberRepository = memberRepository;
        this.emailValidatorService = emailValidatorService;
        this.credentialValidator = credentialValidator;
    }

    public boolean register(Member member){
        if(emailValidatorService.isEmailAddressValid(member.getEmailAddress()) &&
           credentialValidator.isValid(member.getCredential()) )
        {
            memberRepository.add(member);
            return true;
        }
        return false;
    }

    public Member getByEmail(EmailAddress memberEmailAddress) {
        return memberRepository.get(memberEmailAddress);
    }

    public void addNewMember(Member member) {
        if( memberRepository.get(member.getEmailAddress()) == null){
            memberRepository.add(member);
        }
    }

    public void removeMember(Member member) {
        removeByEmail(member.getEmailAddress());
    }

    public void removeByEmail(EmailAddress memberEmailAddress){
        memberRepository.remove(memberEmailAddress);
    }

}
