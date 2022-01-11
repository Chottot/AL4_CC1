package com.chottot.domain.address;

final public class Region {

    private final Country country;
    private final String name;

    public Region(Country country, String name) {
        this.country = country;
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }
}
