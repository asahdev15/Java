package designpatterns.creational.singleton;

public class AirforceOneWithDoubleCheckedLocking {
 
    private volatile static AirforceOneWithDoubleCheckedLocking onlyInstance;
 
    private AirforceOneWithDoubleCheckedLocking() {
    }
 
    public void fly() {
        System.out.println("Airforce one is flying...");
    }
 
    synchronized public static AirforceOneWithDoubleCheckedLocking getInstance() {
        if (onlyInstance == null) {
            synchronized (AirforceOneWithDoubleCheckedLocking.class) {
                if (onlyInstance == null) {
                    onlyInstance = new AirforceOneWithDoubleCheckedLocking();
                }
            }
        }
        return onlyInstance;
    }
}