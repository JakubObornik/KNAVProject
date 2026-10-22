package exercises.exercise1;

import exercises.exercise1.patterns.abstractfactory.AbstractFactoryDemo;
import exercises.exercise1.patterns.builder.Computer;
import exercises.exercise1.patterns.builder.Configuration;
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
                .processor("Intel i9")
                .ram("64 GB")
                .graphicsCard("NVIDIA RTX 4090")
                .powerSupply("1000 W")
                .build();
        System.out.println("Herní počítač:\n" + gamingComputer);

        Computer officeComputer = new OfficeComputerBuilder()
                .storage("1 TB SSD")
                .coolingSystem("Pasivní chlazení")
                .build();
        System.out.println("\nKancelářský počítač:\n" + officeComputer);

        System.out.println("\nSingleton:");
        ConfigurationManager firstManager = ConfigurationManager.getInstance();
        ConfigurationManager secondManager = ConfigurationManager.getInstance();
        System.out.println("Same manager instance: " + (firstManager == secondManager));
        Configuration configuration = secondManager.getConfiguration();
        System.out.println("Uživatel: " + configuration.getUserName()
                + ", jazyk: " + configuration.getLanguage()
                + ", tmavý režim: " + configuration.isDarkMode());

        System.out.println("\nAbstract Factory:");
        AbstractFactoryDemo.run();

        System.out.println("\nFactory Method:");
        FactoryMethodDemo.run();

        System.out.println("\nPrototype:");
        PrototypeDemo.run();
    }
}
