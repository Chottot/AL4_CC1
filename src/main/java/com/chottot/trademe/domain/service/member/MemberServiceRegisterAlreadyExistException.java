package com.chottot.trademe.domain.service.member;

import com.chottot.trademe.domain.member.MemberID;

public class MemberServiceRegisterAlreadyExistException extends MemberServiceException {
    public MemberServiceRegisterAlreadyExistException(MemberID id) {
        super("There is already a member with ID: " + id.toString());
    }
}
