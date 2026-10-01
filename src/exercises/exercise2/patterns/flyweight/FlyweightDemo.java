package exercises.exercise2.patterns.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Shares tree type data while each tree keeps its own position. */
public final class FlyweightDemo {

    private FlyweightDemo() {
    }

    public static void run() {
        Forest forest = new Forest();
        forest.plantTree(2, 4, "Oak", "Green", "Rough bark");
        forest.plantTree(8, 3, "Oak", "Green", "Rough bark");
        forest.plantTree(5, 9, "Pine", "Dark green", "Scaly bark");
        forest.draw();
        System.out.println("Shared tree types: " + TreeFactory.typeCount());
    }

    private record TreeType(String name, String color, String texture) {
        void draw(int x, int y) {
            System.out.println(name + " (" + color + ", " + texture + ") at " + x + "," + y);
        }
    }

    private record Tree(int x, int y, TreeType type) {
        void draw() { type.draw(x, y); }
    }

    private static final class TreeFactory {
        private static final Map<String, TreeType> TYPES = new HashMap<>();

        static TreeType getTreeType(String name, String color, String texture) {
            String key = name + "|" + color + "|" + texture;
            return TYPES.computeIfAbsent(key, ignored -> new TreeType(name, color, texture));
        }

        static int typeCount() { return TYPES.size(); }
    }

    private static final class Forest {
        private final List<Tree> trees = new ArrayList<>();

        void plantTree(int x, int y, String name, String color, String texture) {
            trees.add(new Tree(x, y, TreeFactory.getTreeType(name, color, texture)));
        }

        void draw() { trees.forEach(Tree::draw); }
    }
}
