package com.chottot.trademe.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class MemberDTO {

    @NotBlank
    private String email;
    @NotBlank
    private String lastname;
    @NotBlank
    private String firstname;
    @NotBlank
    private String password;
    @NotBlank
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    public MemberDTO() {
    }

    public MemberDTO(String email, String lastname, String firstname, String password, LocalDate birthDate) {
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
