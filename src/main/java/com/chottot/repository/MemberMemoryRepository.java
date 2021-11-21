package com.chottot.repository;

import com.chottot.email.EmailAddress;
import com.chottot.member.Member;

import java.util.ArrayList;
import java.util.List;

final public class MemberMemoryRepository implements MemberRepository{

    private final List<Member> memberList;

    public MemberMemoryRepository() {
        memberList = new ArrayList<>();
    }

    @Override
    public Member get(EmailAddress memberEmailAddress) {
         return memberList.stream().filter(member1 -> member1.getEmailAddress().equals(memberEmailAddress))
                                    .findAny().orElse(null);
    }

    @Override
    public void add(Member member) {
        if( get(member.getEmailAddress()) == null){
            memberList.add(member);
        }
    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void remove(EmailAddress memberEmailAddress) {
        Member memberInList = get(memberEmailAddress);
        if( memberInList != null){
            memberList.remove(memberInList);
        }
    }
}
