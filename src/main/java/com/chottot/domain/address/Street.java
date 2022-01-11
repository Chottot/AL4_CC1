package com.chottot.domain.address;

final public class Street {

    private final City city;
    private final String name;

    public Street(City city, String name) {
        this.city = city;
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public String getName() {
        return name;
    }
}
