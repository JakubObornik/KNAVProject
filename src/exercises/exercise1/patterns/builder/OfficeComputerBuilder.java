package exercises.exercise1.patterns.builder;

/** Builder with efficient, lower-power defaults for an office computer. */
public final class OfficeComputerBuilder implements ComputerBuilder {

    private String processor = "Intel i5";
    private String ram = "8 GB";
    private String storage = "512 GB SSD";
    private String graphicsCard = "Integrovaná grafika";
    private String powerSupply = "500 W";
    private String coolingSystem = "Vzduchové chlazení";

    @Override
    public OfficeComputerBuilder processor(String processor) {
        this.processor = processor;
        return this;
    }

    @Override
    public OfficeComputerBuilder ram(String ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public OfficeComputerBuilder storage(String storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public OfficeComputerBuilder graphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    @Override
    public OfficeComputerBuilder powerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
        return this;
    }

    @Override
    public OfficeComputerBuilder coolingSystem(String coolingSystem) {
        this.coolingSystem = coolingSystem;
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(processor, ram, storage, graphicsCard, powerSupply, coolingSystem);
    }
}
