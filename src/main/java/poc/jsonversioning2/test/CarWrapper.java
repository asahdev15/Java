package poc.jsonversioning2.test;

public class CarWrapper {
    private VersionedCar car;

    public CarWrapper(VersionedCar car) {
        this.car = car;
    }

    public VersionedCar getCar() {
        return car;
    }

    public void setCar(VersionedCar car) {
        this.car = car;
    }
}