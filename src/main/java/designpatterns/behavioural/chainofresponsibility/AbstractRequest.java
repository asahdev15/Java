package designpatterns.behavioural.chainofresponsibility;

abstract public class AbstractRequest {
 
    // Each request is identified by a an integer
    // FireRequest: 1
    // LowFuelRequest: 2
    private int requestCode;
 
    public AbstractRequest(int requestCode) {
        this.requestCode = requestCode;
    }
 
    public int getRequestCode() {
        return requestCode;
    }
}