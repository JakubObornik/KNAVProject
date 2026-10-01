package exercises.exercise1.patterns.builder;

/**
 * An immutable configuration created step by step with a builder.
 *
 * <pre>{@code
 * Configuration configuration = new Configuration.Builder()
 *         .userName("Jakub")
 *         .language("cs")
 *         .darkMode(true)
 *         .build();
 * }</pre>
 */
public final class Configuration {

    private final String userName;
    private final String language;
    private final boolean darkMode;

    // Only the builder can create a configuration.
    private Configuration(Builder builder) {
        this.userName = builder.userName;
        this.language = builder.language;
        this.darkMode = builder.darkMode;
    }

    public String getUserName() {
        return userName;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public static class Builder {

        // Options keep their defaults when their builder methods are omitted.
        private String userName = "";
        private String language = "en";
        private boolean darkMode = false;

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Builder darkMode(boolean darkMode) {
            this.darkMode = darkMode;
            return this;
        }

        // Each call creates an independent, immutable configuration.
        public Configuration build() {
            return new Configuration(this);
        }
    }
}
