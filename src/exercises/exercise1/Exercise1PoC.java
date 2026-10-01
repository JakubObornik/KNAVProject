package exercises.exercise1;

import exercises.exercise1.patterns.abstractfactory.AbstractFactoryDemo;
import exercises.exercise1.patterns.builder.Computer;
import exercises.exercise1.patterns.builder.GamingComputerBuilder;
import exercises.exercise1.patterns.builder.OfficeComputerBuilder;
import exercises.exercise1.patterns.factorymethod.FactoryMethodDemo;
import exercises.exercise1.patterns.prototype.PrototypeDemo;
import exercises.exercise1.patterns.singleton.ConfigurationManager;

/** Runs the pattern demonstrations for exercise 1. */
public final class Exercise1PoC {

    public static void main(String[] args) {
        System.out.println("Builder:");
        Computer gamingComputer = new GamingComputerBuilder()
                .ram("64 GB")
                .build();
        System.out.println("Herní počítač:\n" + gamingComputer);

        Computer officeComputer = new OfficeComputerBuilder()
                .storage("1 TB SSD")
                .build();
        System.out.println("\nKancelářský počítač:\n" + officeComputer);

        System.out.println("\nSingleton:");
        ConfigurationManager firstManager = ConfigurationManager.getInstance();
        ConfigurationManager secondManager = ConfigurationManager.getInstance();
        System.out.println("Same manager instance: " + (firstManager == secondManager));

        System.out.println("\nAbstract Factory:");
        AbstractFactoryDemo.run();

        System.out.println("\nFactory Method:");
        FactoryMethodDemo.run();

        System.out.println("\nPrototype:");
        PrototypeDemo.run();
    }
}
