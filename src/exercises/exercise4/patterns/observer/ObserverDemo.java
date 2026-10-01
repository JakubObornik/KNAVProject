package exercises.exercise4.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/** Notifies only subscribed customers when a store receives a product. */
public final class ObserverDemo {

    private ObserverDemo() {
    }

    public static void run() {
        Store store = new Store();
        Subscriber ada = new EmailCustomer("Ada");
        Subscriber grace = new SmsCustomer("Grace");
        store.subscribe(ada);
        store.subscribe(grace);

        store.receiveProduct("iPhone");
        store.unsubscribe(grace);
        store.receiveProduct("iPad");
    }

    private interface Subscriber {
        void update(String product);
    }

    /** Publisher: keeps a subscriber list and notifies it through the common interface. */
    private static final class Store {
        private final List<Subscriber> subscribers = new ArrayList<>();

        void subscribe(Subscriber subscriber) { subscribers.add(subscriber); }
        void unsubscribe(Subscriber subscriber) { subscribers.remove(subscriber); }
        void receiveProduct(String product) {
            System.out.println("Store received " + product);
            for (Subscriber subscriber : subscribers) subscriber.update(product);
        }
    }

    private record EmailCustomer(String name) implements Subscriber {
        public void update(String product) { System.out.println("  Email to " + name + ": " + product + " is in stock"); }
    }

    private record SmsCustomer(String name) implements Subscriber {
        public void update(String product) { System.out.println("  SMS to " + name + ": " + product + " is in stock"); }
    }
}
