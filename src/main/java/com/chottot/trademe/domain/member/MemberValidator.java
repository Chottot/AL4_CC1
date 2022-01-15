package com.chottot.trademe.domain.member;

import com.chottot.trademe.domain.credential.CredentialWrongTypeException;
import com.chottot.trademe.domain.credential.ICredentialValidator;
import com.chottot.trademe.domain.email.IEmailValidatorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class MemberValidator implements IMemberValidator {

    private final LocalDate currentDate;
    private final int ageMin;
    private final List<ICredentialValidator> iCredentialValidators;
    private final IEmailValidatorService emailValidatorService;

    private MemberValidator(LocalDate currentDate, int ageMin, List<ICredentialValidator> credentialValidator, IEmailValidatorService emailValidatorService) {
        this.currentDate = currentDate;
        this.ageMin = ageMin;
        this.iCredentialValidators = credentialValidator;
        this.emailValidatorService = emailValidatorService;
    }

    public MemberValidator(int ageMin, List<ICredentialValidator> credentialValidator, IEmailValidatorService emailValidatorService) {
        this(LocalDate.now(), ageMin, credentialValidator, emailValidatorService);
    }

    private void validateCredential(Member member){
        for (ICredentialValidator validator : iCredentialValidators) {
            try {
                validator.validate(member.getCredential());
            } catch (CredentialWrongTypeException ignored) {
            }
        }
    }

    private void validateAge(Member member){
        if (Period.between(member.getBirthDate(), currentDate).getYears() < ageMin) {
            throw new MemberTooYoungException(ageMin);
        }
    }

    private void validateEmail(Member member){
        emailValidatorService.validate(member.getEmailAddress());
    }

    @Override
    public boolean validate(Member member) {
        if (member == null) throw new IllegalArgumentException("member to validate is null");

        validateCredential(member);

        validateAge(member);

        validateEmail(member);

        return true;
    }

    public static MemberValidator createMemberValidatorWithCurrentDate(LocalDate currentDate, int ageMin, List<ICredentialValidator> credentialValidator, IEmailValidatorService emailValidatorService) {
        return new MemberValidator(currentDate, ageMin, credentialValidator, emailValidatorService);
    }

}
