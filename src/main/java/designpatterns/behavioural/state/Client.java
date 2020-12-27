package designpatterns.behavioural.state;

public class Client {
 
    public void main() {
 
        F16 f16 = new F16();
        f16.startsEngine();
        f16.fliesPlane();
        f16.ejectsPlane();
        
    }
}