package com.chottot.domain.address;

final public class City {

    private final Region region;
    private final String name;

    public City(Region region, String name) {
        this.region = region;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Region getRegion() {
        return region;
    }
}
