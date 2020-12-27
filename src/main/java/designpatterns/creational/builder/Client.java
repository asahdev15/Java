package designpatterns.creational.builder;

import designpatterns.creational.builder.builders.F16Builder;
import designpatterns.creational.builder.products.IAircraft;

public class Client {

    public void main() {

        F16Builder f16Builder = new F16Builder();
        Director director = new Director(f16Builder);
        director.construct(false);

        IAircraft f16 = f16Builder.getResult();
    }
}