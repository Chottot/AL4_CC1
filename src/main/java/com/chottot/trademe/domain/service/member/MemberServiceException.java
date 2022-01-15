package com.chottot.trademe.domain.service.member;

import com.chottot.trademe.domain.member.MemberID;

public class MemberServiceException extends RuntimeException{
    public MemberServiceException(String message) {
        super(message);
    }
}

