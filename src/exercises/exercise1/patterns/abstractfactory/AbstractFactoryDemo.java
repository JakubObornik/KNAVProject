package exercises.exercise1.patterns.abstractfactory;

/** Demonstrates creating matching UI controls for different operating systems. */
public final class AbstractFactoryDemo {

    private AbstractFactoryDemo() {
    }

    public static void run() {
        new Application(new WindowsFactory()).paint();
        new Application(new MacOSFactory()).paint();
    }

    private static final class Application {
        private final Button button;
        private final Checkbox checkbox;

        private Application(GUIFactory factory) {
            button = factory.createButton();
            checkbox = factory.createCheckbox();
        }

        private void paint() {
            button.paint();
            checkbox.paint();
        }
    }

    private interface GUIFactory {
        Button createButton();

        Checkbox createCheckbox();
    }

    private interface Button {
        void paint();
    }

    private interface Checkbox {
        void paint();
    }

    private static final class WindowsFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WindowsButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new WindowsCheckbox();
        }
    }

    private static final class MacOSFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new MacOSButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacOSCheckbox();
        }
    }

    private static final class WindowsButton implements Button {
        @Override
        public void paint() {
            System.out.println("Vykreslování tlačítka ve stylu Windows.");
        }
    }

    private static final class MacOSButton implements Button {
        @Override
        public void paint() {
            System.out.println("Vykreslování tlačítka ve stylu macOS.");
        }
    }

    private static final class WindowsCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Vykreslování checkboxu ve stylu Windows.");
        }
    }

    private static final class MacOSCheckbox implements Checkbox {
        @Override
        public void paint() {
            System.out.println("Vykreslování checkboxu ve stylu macOS.");
        }
    }
}
