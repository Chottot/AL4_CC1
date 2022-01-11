package com.chottot.domain.service;

import com.chottot.domain.member.MemberID;

public class MemberServiceException extends RuntimeException{
    public MemberServiceException(String message) {
        super(message);
    }
}

class MemberServiceRegisterNullException extends MemberServiceException {
    public MemberServiceRegisterNullException() {
        super("can't register a null member");
    }
}

class MemberServiceIDNullException extends MemberServiceException {
    public MemberServiceIDNullException() {
        super("Member ID is null");
    }
}

class MemberServiceRegisterAlreadyExistException extends MemberServiceException {
    public MemberServiceRegisterAlreadyExistException(MemberID id) {
        super("There is already a member with ID: "+ id.toString());
    }
}

class MemberServiceMemberDoesNotExistException extends MemberServiceException {
    public MemberServiceMemberDoesNotExistException(MemberID id) {
        super("There is no member with ID: "+ id.toString());
    }
}
