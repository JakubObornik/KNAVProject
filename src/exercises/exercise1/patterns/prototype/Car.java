package exercises.exercise1.patterns.prototype;

import java.util.Objects;

/** A car that can create an independent copy of itself. */
public final class Car implements Prototype<Car> {
    private final String brand;
    private final String model;
    private final String engine;
    private final String color;
    private final int doors;

    public Car(String brand, String model, String engine, String color, int doors) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.doors = doors;
    }

    @Override
    public Car clone() {
        return new Car(brand, model, engine, color, doors);
    }

    public boolean testClone(Car clonedCar) {
        return clonedCar != this
                && clonedCar.equals(this)
                && clonedCar.getClass() == getClass();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Car)) return false;
        Car car = (Car) other;
        return doors == car.doors
                && Objects.equals(brand, car.brand)
                && Objects.equals(model, car.model)
                && Objects.equals(engine, car.engine)
                && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engine, color, doors);
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + engine + ", " + color + ", " + doors + " doors)";
    }
}
