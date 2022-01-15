package com.chottot.trademe.domain.repository;

import com.chottot.trademe.domain.member.Member;
import com.chottot.trademe.domain.member.MemberID;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends IRepository<MemberID, Member>{

}
