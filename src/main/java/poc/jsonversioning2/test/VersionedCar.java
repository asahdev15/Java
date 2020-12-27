package poc.jsonversioning2.test;

import poc.jsonversioning2.annotations.JsonSince;
import poc.jsonversioning2.annotations.JsonUntil;
import poc.jsonversioning2.annotations.JsonVersioned;

@JsonVersioned("1.0")
public class VersionedCar {

    @JsonUntil("0.9")
    private Integer capacity = 5;
    @JsonSince("0.8")
    private String model = "Rav4";
    private String make = "Toyota";
    // annotations should work whether it is put on the fields or on the getters
    @JsonSince("0.2")
    @JsonUntil("0.7")
    private Boolean validBetween2to7 = true;
    @JsonUntil("0.2")
    @JsonSince("0.7")
    private Boolean omittedBetween2to6 = true;

    public VersionedCar() {
    }

    public VersionedCar(Integer capacity, String model, String make, Boolean validBetween2to7) {
        this.capacity = capacity;
        this.model = model;
        this.make = make;
        this.validBetween2to7 = validBetween2to7;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public Boolean getValidBetween2to7() {
        return validBetween2to7;
    }

    public Boolean getOmittedBetween2to6() {
        return omittedBetween2to6;
    }
}