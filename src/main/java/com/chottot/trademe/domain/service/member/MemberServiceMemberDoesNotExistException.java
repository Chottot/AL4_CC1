package com.chottot.trademe.domain.service.member;

import com.chottot.trademe.domain.member.MemberID;

public class MemberServiceMemberDoesNotExistException extends MemberServiceException {
    public MemberServiceMemberDoesNotExistException(MemberID id) {
        super("There is no member with ID: " + id.toString());
    }
}
