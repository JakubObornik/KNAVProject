package exercises.exercise2;

import exercises.exercise2.patterns.adapter.AdapterDemo;
import exercises.exercise2.patterns.bridge.BridgeDemo;
import exercises.exercise2.patterns.composite.CompositeDemo;
import exercises.exercise2.patterns.decorator.DecoratorDemo;
import exercises.exercise2.patterns.facade.FacadeDemo;
import exercises.exercise2.patterns.flyweight.FlyweightDemo;

/** Runs all design pattern demonstrations from practical block 2. */
public final class Exercise2PoC {

    private Exercise2PoC() {
    }

    public static void main(String[] args) {
        System.out.println("Adapter:");
        AdapterDemo.run();
        System.out.println("\nBridge:");
        BridgeDemo.run();
        System.out.println("\nComposite:");
        CompositeDemo.run();
        System.out.println("\nDecorator:");
        DecoratorDemo.run();
        System.out.println("\nFacade:");
        FacadeDemo.run();
        System.out.println("\nFlyweight:");
        FlyweightDemo.run();
    }
}
