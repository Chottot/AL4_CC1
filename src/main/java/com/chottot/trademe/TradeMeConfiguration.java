package com.chottot.trademe;

import com.chottot.trademe.domain.credential.LoginPassword.LoginPasswordValidator;
import com.chottot.trademe.domain.member.MemberValidator;
import com.chottot.trademe.domain.service.EmailValidatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TradeMeConfiguration {

    @Bean
    public MemberValidator getMemberValidator(){
        return new MemberValidator(18, List.of(new LoginPasswordValidator(0, 20)), new EmailValidatorService());
    }

}
