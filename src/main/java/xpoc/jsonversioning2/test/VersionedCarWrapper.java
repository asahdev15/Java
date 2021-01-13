package xpoc.jsonversioning2.test;

import xpoc.jsonversioning2.annotations.JsonVersioned;

@JsonVersioned("1.0")
public class VersionedCarWrapper {
    private VersionedCar car;

    public VersionedCarWrapper(VersionedCar car) {
        this.car = car;
    }

    public VersionedCar getCar() {
        return car;
    }

    public void setCar(VersionedCar car) {
        this.car = car;
    }
}