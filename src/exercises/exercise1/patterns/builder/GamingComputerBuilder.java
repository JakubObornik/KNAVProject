package exercises.exercise1.patterns.builder;

/** Builder with performance-oriented defaults for a gaming computer. */
public final class GamingComputerBuilder implements ComputerBuilder {

    private String processor = "AMD Ryzen 7";
    private String ram = "32 GB";
    private String storage = "1 TB SSD";
    private String graphicsCard = "NVIDIA RTX 3080";
    private String powerSupply = "750 W";
    private String coolingSystem = "Vodní chlazení";

    @Override
    public GamingComputerBuilder processor(String processor) {
        this.processor = processor;
        return this;
    }

    @Override
    public GamingComputerBuilder ram(String ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public GamingComputerBuilder storage(String storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public GamingComputerBuilder graphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    @Override
    public GamingComputerBuilder powerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
        return this;
    }

    @Override
    public GamingComputerBuilder coolingSystem(String coolingSystem) {
        this.coolingSystem = coolingSystem;
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(processor, ram, storage, graphicsCard, powerSupply, coolingSystem);
    }
}
