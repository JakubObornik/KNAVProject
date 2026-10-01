package exercises.exercise1.patterns.prototype;

import java.util.HashMap;
import java.util.Map;

/** Stores car prototypes and returns a fresh clone for each request. */
public final class CarRegistry {
    private final Map<String, Prototype<Car>> prototypes = new HashMap<>();

    public void addPrototype(String key, Prototype<Car> carPrototype) {
        prototypes.put(key, carPrototype);
    }

    public Car getPrototype(String key) {
        Prototype<Car> prototype = prototypes.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("Unknown car prototype: " + key);
        }
        return prototype.clone();
    }
}
