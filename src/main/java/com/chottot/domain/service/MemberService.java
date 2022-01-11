package com.chottot.domain.service;

import com.chottot.domain.member.IMemberValidator;
import com.chottot.domain.member.Member;
import com.chottot.domain.member.MemberID;
import com.chottot.domain.repository.MemberRepository;

public class MemberService {

    MemberRepository memberRepository;
    IMemberValidator memberValidator;

    public MemberService(MemberRepository memberRepository, IMemberValidator memberValidator) {
        this.memberRepository = memberRepository;
        this.memberValidator = memberValidator;
    }

    public boolean register(Member member) {
        if (member == null)
            throw new MemberServiceRegisterNullException();
        memberValidator.validate(member);

        if (memberRepository.get(member.getID()) != null)
            throw new MemberServiceRegisterAlreadyExistException(member.getID());
        memberRepository.add(member);

        return true;
    }

    public Member getByID(MemberID memberID) {
        if (memberID == null)
            throw new MemberServiceIDNullException();
        Member member = memberRepository.get(memberID);

        if (member == null)
            throw new MemberServiceMemberDoesNotExistException(memberID);

        return member;
    }

    public void removeMember(MemberID memberID) {
        if (memberID == null)
            throw new MemberServiceIDNullException();

        if (memberRepository.get(memberID) != null)
            throw new MemberServiceMemberDoesNotExistException(memberID);

        memberRepository.remove(memberID);
    }

}
