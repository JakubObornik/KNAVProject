package exercises.exercise1.patterns.builder;

/** A computer assembled from individually selected components. */
public final class Computer {

    private final String processor;
    private final String ram;
    private final String storage;
    private final String graphicsCard;
    private final String powerSupply;
    private final String coolingSystem;

    Computer(String processor, String ram, String storage, String graphicsCard,
             String powerSupply, String coolingSystem) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
        this.powerSupply = powerSupply;
        this.coolingSystem = coolingSystem;
    }

    @Override
    public String toString() {
        return "Procesor: " + processor
                + "\nRAM: " + ram
                + "\nÚložiště: " + storage
                + "\nGrafická karta: " + graphicsCard
                + "\nNapájecí zdroj: " + powerSupply
                + "\nChlazení: " + coolingSystem;
    }
}
