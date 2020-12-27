package designpatterns.creational.builder.builders;

import designpatterns.creational.builder.products.Boeing747;
import designpatterns.creational.builder.products.IAircraft;

public class Boeing747Builder extends AircraftBuilder {

    Boeing747 boeing747;

    @Override
    public void buildCockpit() {

    }

    @Override
    public void buildEngine() {

    }

    @Override
    public void buildBathrooms() {
        
    }

    @Override
    public void buildWings() {

    }

    public IAircraft getResult() {
        return boeing747;
    }
}