package com.chottot.trademe.domain.repository;

import com.chottot.trademe.domain.member.Member;
import com.chottot.trademe.domain.member.MemberID;

import java.util.ArrayList;
import java.util.List;

final public class MemberMemoryRepository implements MemberRepository{

    private final List<Member> memberList;

    public MemberMemoryRepository() {
        memberList = new ArrayList<>();
    }

    @Override
    public Member get(MemberID key) {
         return memberList.stream().filter(member1 -> member1.getID().equals(key))
                                    .findAny().orElse(null);
    }

    @Override
    public void add(Member key) {
        memberList.add(key);
    }

    @Override
    public void update(Member key) {

    }

    @Override
    public void remove(MemberID key) {
        Member memberInList = get(key);
        if( memberInList != null){
            memberList.remove(memberInList);
        }
    }

    @Override
    public List<Member> getAll() {
        return memberList;
    }
}
