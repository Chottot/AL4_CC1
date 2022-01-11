package com.chottot.domain.member.worker;

import com.chottot.domain.address.City;
import com.chottot.domain.member.Member;

import java.util.List;

public class Worker {

    private final Member member;
    private final List<Skill> skills;
    private final List<Certificate> certificates;
    private final List<City> workingCity;

    public Worker(Member member, List<Skill> skills, List<Certificate> certificates, List<City> workingCitys) {
        this.member = member;
        this.skills = skills;
        this.certificates = certificates;
        this.workingCity = workingCitys;
    }

    public Member getMember() {
        return member;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public List<City> getWorkingCity() {
        return workingCity;
    }
}
