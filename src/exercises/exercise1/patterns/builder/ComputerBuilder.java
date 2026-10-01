package exercises.exercise1.patterns.builder;

/** Fluent steps for configuring and building a computer. */
public interface ComputerBuilder {

    ComputerBuilder processor(String processor);

    ComputerBuilder ram(String ram);

    ComputerBuilder storage(String storage);

    ComputerBuilder graphicsCard(String graphicsCard);

    ComputerBuilder powerSupply(String powerSupply);

    ComputerBuilder coolingSystem(String coolingSystem);

    Computer build();
}
