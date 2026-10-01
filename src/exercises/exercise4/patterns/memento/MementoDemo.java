package exercises.exercise4.patterns.memento;

import java.util.ArrayDeque;
import java.util.Deque;

/** Saves and restores editor snapshots without exposing the editor's private state. */
public final class MementoDemo {

    private MementoDemo() {
    }

    public static void run() {
        Editor editor = new Editor();
        History history = new History();

        history.push(editor.save("type title"));
        editor.type("Design patterns");
        history.push(editor.save("type body"));
        editor.type(" are reusable solutions.");
        history.push(editor.save("scroll down"));
        editor.scrollTo(12);
        System.out.println("Current: " + editor);
        System.out.println("History: " + history.describe());

        editor.restore(history.pop());
        System.out.println("Undo:    " + editor);
        editor.restore(history.pop());
        System.out.println("Undo:    " + editor);
    }

    /** Narrow interface for caretakers: metadata only, never the saved state. */
    private interface Memento {
        String operation();
    }

    /** Originator: the only class that can create and read its snapshots. */
    private static final class Editor {
        private String text = "";
        private int cursor;
        private int scroll;

        void type(String value) { text += value; cursor = text.length(); }
        void scrollTo(int position) { scroll = position; }

        Memento save(String operation) { return new Snapshot(operation, text, cursor, scroll); }
        void restore(Memento memento) {
            Snapshot snapshot = (Snapshot) memento;
            text = snapshot.text;
            cursor = snapshot.cursor;
            scroll = snapshot.scroll;
        }

        public String toString() { return "\"" + text + "\" cursor=" + cursor + " scroll=" + scroll; }

        private record Snapshot(String operation, String text, int cursor, int scroll) implements Memento {
        }
    }

    /** Caretaker: keeps the undo stack but cannot touch the stored state. */
    private static final class History {
        private final Deque<Memento> mementos = new ArrayDeque<>();

        void push(Memento memento) { mementos.push(memento); }
        Memento pop() { return mementos.pop(); }
        String describe() {
            StringBuilder result = new StringBuilder();
            for (Memento memento : mementos) result.append("[before ").append(memento.operation()).append("] ");
            return result.toString().trim();
        }
    }
}
