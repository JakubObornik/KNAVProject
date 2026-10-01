package exercises.exercise3.patterns.mediator;

import java.util.ArrayList;
import java.util.List;

/** Relays chat messages through a mediator rather than direct user links. */
public final class MediatorDemo {

    private MediatorDemo() {
    }

    public static void run() {
        ChatMediator chat = new ChatRoom();
        User ada = new ChatUser("Ada", chat);
        User grace = new ChatUser("Grace", chat);
        User linus = new ChatUser("Linus", chat);
        chat.addUser(ada);
        chat.addUser(grace);
        chat.addUser(linus);
        ada.send("Hello everyone");
    }

    private interface ChatMediator {
        void sendMessage(String message, User sender);
        void addUser(User user);
    }

    private abstract static class User {
        private final String name;
        private final ChatMediator mediator;

        private User(String name, ChatMediator mediator) {
            this.name = name;
            this.mediator = mediator;
        }

        void send(String message) { mediator.sendMessage(message, this); }
        abstract void receive(String message);
        String name() { return name; }
    }

    private static final class ChatUser extends User {
        private ChatUser(String name, ChatMediator mediator) { super(name, mediator); }
        void receive(String message) { System.out.println(name() + " received: " + message); }
    }

    private static final class ChatRoom implements ChatMediator {
        private final List<User> users = new ArrayList<>();
        public void addUser(User user) { users.add(user); }
        public void sendMessage(String message, User sender) {
            for (User user : users) {
                if (user != sender) user.receive(sender.name() + ": " + message);
            }
        }
    }
}
