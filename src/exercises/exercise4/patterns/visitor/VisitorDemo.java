package exercises.exercise4.patterns.visitor;

import java.util.List;

/** Adds XML export and statistics to geo nodes without putting that logic in the node classes. */
public final class VisitorDemo {

    private VisitorDemo() {
    }

    public static void run() {
        List<Node> graph = List.of(
                new City("Pardubice", 90_000),
                new Industry("Chemical plant", 3_500),
                new SightSeeing("Pardubice Castle"));

        XmlExportVisitor xml = new XmlExportVisitor();
        for (Node node : graph) node.accept(xml);
        System.out.println(xml.result());

        StatisticsVisitor statistics = new StatisticsVisitor();
        for (Node node : graph) node.accept(statistics);
        System.out.println("People in graph: " + statistics.people());
    }

    /** The only change to node classes: accept() performs the double dispatch. */
    private interface Node {
        void accept(Visitor visitor);
    }

    private record City(String name, int population) implements Node {
        public void accept(Visitor visitor) { visitor.visitCity(this); }
    }

    private record Industry(String name, int employees) implements Node {
        public void accept(Visitor visitor) { visitor.visitIndustry(this); }
    }

    private record SightSeeing(String name) implements Node {
        public void accept(Visitor visitor) { visitor.visitSightSeeing(this); }
    }

    private interface Visitor {
        void visitCity(City city);
        void visitIndustry(Industry industry);
        void visitSightSeeing(SightSeeing sightSeeing);
    }

    private static final class XmlExportVisitor implements Visitor {
        private final StringBuilder xml = new StringBuilder("<graph>\n");

        public void visitCity(City city) {
            xml.append("  <city name=\"").append(city.name()).append("\" population=\"").append(city.population()).append("\"/>\n");
        }
        public void visitIndustry(Industry industry) {
            xml.append("  <industry name=\"").append(industry.name()).append("\" employees=\"").append(industry.employees()).append("\"/>\n");
        }
        public void visitSightSeeing(SightSeeing sightSeeing) {
            xml.append("  <sight name=\"").append(sightSeeing.name()).append("\"/>\n");
        }
        String result() { return xml + "</graph>"; }
    }

    private static final class StatisticsVisitor implements Visitor {
        private int people;

        public void visitCity(City city) { people += city.population(); }
        public void visitIndustry(Industry industry) { people += industry.employees(); }
        public void visitSightSeeing(SightSeeing sightSeeing) {
        }
        int people() { return people; }
    }
}
