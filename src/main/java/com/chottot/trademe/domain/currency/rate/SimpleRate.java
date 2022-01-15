package com.chottot.trademe.domain.currency.rate;

public abstract class SimpleRate implements IRate{

    private final double rate;

    public SimpleRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double getRate() {
        return rate;
    }
}
