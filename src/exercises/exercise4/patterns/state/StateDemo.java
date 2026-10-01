package exercises.exercise4.patterns.state;

/** Moves a document through Draft, Moderation, and Published states. */
public final class StateDemo {

    private StateDemo() {
    }

    public static void run() {
        Document document = new Document();
        document.publish(false);
        document.publish(false);
        document.publish(true);
        document.publish(true);
    }

    private interface State {
        void publish(Document document, boolean isAdmin);
        String name();
    }

    /** Context: delegates state-specific behavior to its current state object. */
    private static final class Document {
        private State state = new Draft();

        void changeState(State next) {
            System.out.println("  " + state.name() + " -> " + next.name());
            state = next;
        }
        void publish(boolean isAdmin) {
            System.out.println("publish() by " + (isAdmin ? "admin" : "author") + " in " + state.name());
            state.publish(this, isAdmin);
        }
    }

    private static final class Draft implements State {
        public void publish(Document document, boolean isAdmin) { document.changeState(new Moderation()); }
        public String name() { return "Draft"; }
    }

    private static final class Moderation implements State {
        public void publish(Document document, boolean isAdmin) {
            if (isAdmin) document.changeState(new Published());
            else System.out.println("  Only an admin can publish a moderated document");
        }
        public String name() { return "Moderation"; }
    }

    private static final class Published implements State {
        public void publish(Document document, boolean isAdmin) { System.out.println("  Already published, nothing happens"); }
        public String name() { return "Published"; }
    }
}
