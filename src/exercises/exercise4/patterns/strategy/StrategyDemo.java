package exercises.exercise4.patterns.strategy;

import java.util.List;

/** Swaps route-building algorithms in a navigator at runtime. */
public final class StrategyDemo {

    private StrategyDemo() {
    }

    public static void run() {
        Navigator navigator = new Navigator(new RoadStrategy());
        navigator.buildRoute("Station", "Airport");
        navigator.setStrategy(new WalkingStrategy());
        navigator.buildRoute("Station", "Airport");
        navigator.setStrategy(new PublicTransportStrategy());
        navigator.buildRoute("Station", "Airport");
    }

    private interface RouteStrategy {
        List<String> buildRoute(String from, String to);
    }

    /** Context: renders checkpoints without knowing which algorithm produced them. */
    private static final class Navigator {
        private RouteStrategy strategy;

        private Navigator(RouteStrategy strategy) { this.strategy = strategy; }
        void setStrategy(RouteStrategy strategy) { this.strategy = strategy; }
        void buildRoute(String from, String to) {
            System.out.println(strategy.getClass().getSimpleName() + ": " + String.join(" -> ", strategy.buildRoute(from, to)));
        }
    }

    private static final class RoadStrategy implements RouteStrategy {
        public List<String> buildRoute(String from, String to) { return List.of(from, "Ring road", "Highway D11", to); }
    }

    private static final class WalkingStrategy implements RouteStrategy {
        public List<String> buildRoute(String from, String to) { return List.of(from, "Park", "Old town", "Footbridge", to); }
    }

    private static final class PublicTransportStrategy implements RouteStrategy {
        public List<String> buildRoute(String from, String to) { return List.of(from, "Bus 119", to); }
    }
}
