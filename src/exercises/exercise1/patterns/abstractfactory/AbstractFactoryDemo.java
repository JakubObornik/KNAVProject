package exercises.exercise1.patterns.abstractfactory;

/** Demonstrates creating related UI controls from one matching family. */
public final class AbstractFactoryDemo {

    private AbstractFactoryDemo() {
    }

    public static void run() {
        showControls(new LightThemeFactory());
        showControls(new DarkThemeFactory());
    }

    private static void showControls(UIFactory factory) {
        System.out.println(factory.createButton().render());
        System.out.println(factory.createCheckbox().render());
    }

    private interface UIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }

    private interface Button {
        String render();
    }

    private interface Checkbox {
        String render();
    }

    private static final class LightThemeFactory implements UIFactory {
        public Button createButton() { return () -> "Light button"; }
        public Checkbox createCheckbox() { return () -> "Light checkbox"; }
    }

    private static final class DarkThemeFactory implements UIFactory {
        public Button createButton() { return () -> "Dark button"; }
        public Checkbox createCheckbox() { return () -> "Dark checkbox"; }
    }
}
