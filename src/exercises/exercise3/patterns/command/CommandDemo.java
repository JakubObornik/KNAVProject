package exercises.exercise3.patterns.command;

import java.util.ArrayDeque;
import java.util.Deque;

/** Encapsulates text edits so the invoker can undo them. */
public final class CommandDemo {

    private CommandDemo() {
    }

    public static void run() {
        TextEditor editor = new TextEditor();
        Invoker invoker = new Invoker();
        invoker.executeCommand(new WriteTextCommand(editor, "Hello"));
        invoker.executeCommand(new WriteTextCommand(editor, " world"));
        System.out.println("After writes: " + editor.getText());
        invoker.undoLastCommand();
        System.out.println("After undo: " + editor.getText());
        invoker.executeCommand(new WriteTextCommand(editor, " world"));
        invoker.executeCommand(new DeleteTextCommand(editor));
        System.out.println("After deleting last word: " + editor.getText());
        invoker.undoLastCommand();
        System.out.println("After restoring deleted word: " + editor.getText());
    }

    private interface Command {
        void execute();
        void undo();
    }

    private static final class TextEditor {
        private String text = "";
        void write(String value) { text += value; }
        String deleteLastWord() {
            String before = text;
            int end = text.length();
            while (end > 0 && Character.isWhitespace(text.charAt(end - 1))) end--;
            int start = end;
            while (start > 0 && !Character.isWhitespace(text.charAt(start - 1))) start--;
            int cut = start;
            while (cut > 0 && Character.isWhitespace(text.charAt(cut - 1))) cut--;
            text = text.substring(0, cut);
            return before;
        }
        String getText() { return text; }
        void restore(String value) { text = value; }
    }

    private static final class WriteTextCommand implements Command {
        private final TextEditor editor;
        private final String text;
        private String before;

        private WriteTextCommand(TextEditor editor, String text) { this.editor = editor; this.text = text; }
        public void execute() { before = editor.getText(); editor.write(text); }
        public void undo() { editor.restore(before); }
    }

    private static final class DeleteTextCommand implements Command {
        private final TextEditor editor;
        private String before;

        private DeleteTextCommand(TextEditor editor) { this.editor = editor; }
        public void execute() { before = editor.deleteLastWord(); }
        public void undo() { editor.restore(before); }
    }

    private static final class Invoker {
        private final Deque<Command> commandHistory = new ArrayDeque<>();

        void executeCommand(Command command) { command.execute(); commandHistory.push(command); }
        void undoLastCommand() {
            if (!commandHistory.isEmpty()) commandHistory.pop().undo();
        }
    }
}
