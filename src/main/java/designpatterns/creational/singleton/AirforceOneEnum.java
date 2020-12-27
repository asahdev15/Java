package designpatterns.creational.singleton;

public enum AirforceOneEnum {

    INSTANCE;

    public void fly() {
        System.out.println("Airforce one is flying...");
    }
}
