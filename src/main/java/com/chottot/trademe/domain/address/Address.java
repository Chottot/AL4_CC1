package com.chottot.trademe.domain.address;

public class Address {

    private final Street street;
    private final int number;

    public Address(Street street, int number) {
        this.street = street;
        this.number = number;
    }

    public Street getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }
}
