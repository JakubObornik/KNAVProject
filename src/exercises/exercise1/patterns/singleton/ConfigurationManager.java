package exercises.exercise1.patterns.singleton;

import exercises.exercise1.patterns.builder.Configuration;

public class ConfigurationManager {

    // Eager initialization makes access to the singleton thread-safe.
    private static final ConfigurationManager INSTANCE = new ConfigurationManager();

    private final Configuration configuration;

    private ConfigurationManager() {
        configuration = loadConfiguration();
    }

    public static ConfigurationManager getInstance() {
        return INSTANCE;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    private Configuration loadConfiguration() {
        return new Configuration.Builder()
                .userName("Jakub")
                .language("cs")
                .darkMode(true)
                .build();
    }
}
