package exercises.exercise1.patterns.factorymethod;

/** Demonstrates choosing a delivery transport through a factory method. */
public final class FactoryMethodDemo {

    private FactoryMethodDemo() {
    }

    public static void run() {
        DeliveryType[] deliveryTypes = {DeliveryType.ROAD, DeliveryType.SEA, DeliveryType.BICYCLE};
        for (DeliveryType type : deliveryTypes) {
            Logistics logistics = configure(type);
            logistics.planDelivery();
        }
    }

    public static Logistics configure(DeliveryType type) {
        return switch (type) {
            case ROAD -> new RoadLogistics();
            case SEA -> new SeaLogistics();
            case BICYCLE -> new BicycleLogistics();
        };
    }

    private enum DeliveryType {
        ROAD,
        SEA,
        BICYCLE
    }

    private interface Transport {
        String deliver();
    }

    private abstract static class Logistics {
        protected abstract Transport createTransport();

        public void planDelivery() {
            System.out.println(createTransport().deliver());
        }
    }

    private static final class RoadLogistics extends Logistics {
        protected Transport createTransport() {
            return () -> "Delivering by truck.";
        }
    }

    private static final class SeaLogistics extends Logistics {
        protected Transport createTransport() {
            return () -> "Delivering by ship.";
        }
    }

    private static final class BicycleLogistics extends Logistics {
        protected Transport createTransport() {
            return () -> "Delivering by bicycle.";
        }
    }
}
