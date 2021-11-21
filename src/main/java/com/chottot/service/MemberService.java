package com.chottot.service;

import com.chottot.email.EmailAddress;
import com.chottot.email.IEmailValidatorService;
import com.chottot.member.Member;
import com.chottot.member.PasswordValidator;
import com.chottot.repository.MemberRepository;

public class MemberService{

    MemberRepository memberRepository;
    IEmailValidatorService emailValidatorService;
    PasswordValidator credentialValidator;

    public MemberService(MemberRepository memberRepository, IEmailValidatorService emailValidatorService, PasswordValidator credentialValidator) {
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
