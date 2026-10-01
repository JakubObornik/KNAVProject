package exercises.exercise1;

import exercises.exercise1.patterns.abstractfactory.AbstractFactoryDemo;
import exercises.exercise1.patterns.builder.Configuration;
import exercises.exercise1.patterns.factorymethod.FactoryMethodDemo;
import exercises.exercise1.patterns.prototype.PrototypeDemo;
import exercises.exercise1.patterns.singleton.ConfigurationManager;

/** Runs the pattern demonstrations for exercise 1. */
public final class Exercise1PoC {

    public static void main(String[] args) {
        System.out.println("Builder:");
        Configuration configuration = new Configuration.Builder()
                .userName("Jakub")
                .language("cs")
                .darkMode(true)
                .build();
        System.out.println("User name: " + configuration.getUserName());
        System.out.println("Language: " + configuration.getLanguage());
        System.out.println("Dark mode: " + configuration.isDarkMode());

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
