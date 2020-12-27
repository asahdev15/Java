package designpatterns.structural.adaptor;

public class Adapter implements IAircraft {
 
    HotAirBalloon hotAirBalloon;
 
    public Adapter(HotAirBalloon hotAirBalloon) {
        this.hotAirBalloon = hotAirBalloon;
    }
 
    @Override
    public void fly() {
        String feulUsed = hotAirBalloon.inflateWithGas();
        hotAirBalloon.fly(feulUsed);
    }
}