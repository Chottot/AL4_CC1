package com.chottot.trademe.api.controller;

import com.chottot.trademe.api.dto.MemberDTO;
import com.chottot.trademe.domain.credential.password.PasswordCredential;
import com.chottot.trademe.domain.email.EmailAddress;
import com.chottot.trademe.domain.member.Member;
import com.chottot.trademe.domain.member.MemberID;
import com.chottot.trademe.domain.service.member.MemberService;
import com.chottot.trademe.domain.service.member.MemberServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members")
    public List<Member> getMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping(value = "/members/{email}")
    public Member getMember(@PathVariable @Valid String email) {
        return memberService.getByID(new MemberID(new EmailAddress(email)));
    }

    @PostMapping(value = "/members")
    public Member subscribeMember(@RequestBody @Valid MemberDTO memberDTO) {
        return memberService.register(
                new Member(memberDTO.getFirstname(),
                        memberDTO.getLastname(),
                        new PasswordCredential(memberDTO.getPassword()),
                        new EmailAddress(memberDTO.getEmail()),
                        memberDTO.getBirthDate())
        );
    }

    @DeleteMapping(value = "/members/{email}")
    public void deleteMember(@PathVariable @Valid String email) {
        memberService.removeMember(new MemberID(new EmailAddress(email)));
    }


    @ExceptionHandler(value = {MemberServiceException.class})
    public ResponseEntity<String> manageMemberNotFoundException(final MemberServiceException memberNotFoundException) {
        return ResponseEntity.status(404).body(memberNotFoundException.getMessage());
    }

}
