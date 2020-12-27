package designpatterns.structural.facade;

public class BoeingEngineController {
    int engineSoeed;
    public void setEngineSpeed(int i) {
        engineSoeed=i;
    }

    public int getEngineSpeed() {
        return engineSoeed;
    }

    public void turnOff() {
    }
}
