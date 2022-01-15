package com.chottot.trademe.domain.member;

import com.chottot.trademe.domain.credential.CredentialWrongTypeException;
import com.chottot.trademe.domain.credential.ICredentialValidator;
import com.chottot.trademe.domain.email.IEmailValidatorService;

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

    @Override
    public boolean validate(Member member) {
        if (member == null) return false;

        //get matching credential validator
        ICredentialValidator credentialValidator = null;
        for (ICredentialValidator va : iCredentialValidators) {
            try {
                va.canCredentialBeValida(member.getCredential());
            } catch (CredentialWrongTypeException e) {
                continue;
            }

            credentialValidator = va;
        }

        if (credentialValidator == null) {
            throw new MemberValidatorNoCredentialValidatorException(member.getCredential());
        }
        credentialValidator.validate(member.getCredential());

        if (Period.between(member.getBirthDate(), currentDate).getYears() < ageMin) {
            throw new MemberTooYoungException(ageMin);
        }

        return emailValidatorService.isEmailAddressValid(member.getEmailAddress());
    }

    public static MemberValidator createMemberValidatorWithCurrentDate(LocalDate currentDate, int ageMin, List<ICredentialValidator> credentialValidator, IEmailValidatorService emailValidatorService) {
        return new MemberValidator(currentDate, ageMin, credentialValidator, emailValidatorService);
    }

}
