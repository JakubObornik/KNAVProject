package exercises.exercise2.patterns.decorator;

/** Adds message processing features by wrapping the same Message interface. */
public final class DecoratorDemo {

    private DecoratorDemo() {
    }

    public static void run() {
        Message message = new SimpleMessage("Hello World from Java");
        System.out.println("Original: " + message.getContent());
        System.out.println("Encrypted: " + new EncryptionDecorator(message).getContent());
        System.out.println("Compressed: " + new CompressionDecorator(message).getContent());
        System.out.println("With word count: " + new WordCountDecorator(message).getContent());
        Message composed = new WordCountDecorator(
                new CompressionDecorator(new EncryptionDecorator(message)));
        System.out.println("Composed: " + composed.getContent());
    }

    private interface Message {
        String getContent();
    }

    private record SimpleMessage(String getContent) implements Message {
    }

    private abstract static class MessageDecorator implements Message {
        private final Message message;

        private MessageDecorator(Message message) {
            this.message = message;
        }

        protected String content() { return message.getContent(); }
    }

    private static final class EncryptionDecorator extends MessageDecorator {
        private EncryptionDecorator(Message message) { super(message); }
        public String getContent() {
            return content().chars().mapToObj(c -> Character.toString((char) (c + 1)))
                    .reduce("", String::concat);
        }
    }

    private static final class CompressionDecorator extends MessageDecorator {
        private CompressionDecorator(Message message) { super(message); }
        public String getContent() { return content().replaceAll("\\s+", ""); }
    }

    private static final class WordCountDecorator extends MessageDecorator {
        private WordCountDecorator(Message message) { super(message); }
        public String getContent() {
            String original = content().trim();
            int wordCount = original.isEmpty() ? 0 : original.split("\\s+").length;
            return original + " (Word Count: " + wordCount + ")";
        }
    }
}
