package web.model;

import java.util.*;

public class Car {
    private String model;
    private int price;

    public Car() {
    }

    public Car(String model, int price, boolean wasBroken) {
        this.model = model;
        this.price = price;
        this.wasBroken = wasBroken;
    }

    private boolean wasBroken;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isWasBroken() {
        return wasBroken;
    }

    public void setWasBroken(boolean wasBroken) {
        this.wasBroken = wasBroken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price);
    }
}
