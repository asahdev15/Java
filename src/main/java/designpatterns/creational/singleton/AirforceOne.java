package designpatterns.creational.singleton;

public class AirforceOne {

    // The sole instance of the class
    private static AirforceOne onlyInstance;

    // Make the constructor private so its only accessible to
    // members of the class.
    private AirforceOne() {
    }

    // Create a static method for object creation
    public static synchronized AirforceOne getInstance() {
        if (onlyInstance == null) {
            onlyInstance = new AirforceOne();
        }
        return onlyInstance;
    }

    public void fly() {
        System.out.println("Airforce one is flying...");
    }
}