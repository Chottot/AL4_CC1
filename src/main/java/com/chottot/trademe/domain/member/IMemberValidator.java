package com.chottot.trademe.domain.member;

import org.springframework.stereotype.Service;

@Service
public interface IMemberValidator {

    boolean validate(Member member);


}
