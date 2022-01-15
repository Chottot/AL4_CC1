package com.chottot.trademe.domain.service;

import com.chottot.trademe.domain.member.IMemberValidator;
import com.chottot.trademe.domain.member.Member;
import com.chottot.trademe.domain.member.MemberID;
import com.chottot.trademe.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    MemberRepository memberRepository;
    IMemberValidator memberValidator;

    public MemberService(MemberRepository memberRepository, IMemberValidator memberValidator) {
        this.memberRepository = memberRepository;
        this.memberValidator = memberValidator;
    }

    public List<Member> getAllMembers(){
        return  memberRepository.getAll();
    }

    public Member register(Member member) {
        if (member == null)
            throw new MemberServiceRegisterNullException();
        memberValidator.validate(member);

        if (memberRepository.get(member.getID()) != null)
            throw new MemberServiceRegisterAlreadyExistException(member.getID());
        memberRepository.add(member);

        return member;
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
