package exercises.exercise1.patterns.prototype;

/** Demonstrates registering car prototypes and cloning them on demand. */
public final class PrototypeDemo {

    private PrototypeDemo() {
    }

    public static void run() {
        CarRegistry registry = new CarRegistry();
        Car sedanPrototype = new Car("Skoda", "Octavia", "2.0 TDI", "blue", 5);
        registry.addPrototype("sedan", sedanPrototype);

        Car firstCar = registry.getPrototype("sedan");
        Car secondCar = registry.getPrototype("sedan");

        System.out.println("Prototype: " + sedanPrototype);
        System.out.println("Clone: " + firstCar);
        System.out.println("Clone meets the requirements: " + sedanPrototype.testClone(firstCar));
        System.out.println("Each request returns a new object: " + (firstCar != secondCar));
    }
}
