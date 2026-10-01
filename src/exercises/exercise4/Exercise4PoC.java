package exercises.exercise4;

import exercises.exercise4.patterns.memento.MementoDemo;
import exercises.exercise4.patterns.observer.ObserverDemo;
import exercises.exercise4.patterns.state.StateDemo;
import exercises.exercise4.patterns.strategy.StrategyDemo;
import exercises.exercise4.patterns.templatemethod.TemplateMethodDemo;
import exercises.exercise4.patterns.visitor.VisitorDemo;

/** Runs all design pattern demonstrations from block 4. */
public final class Exercise4PoC {

    private Exercise4PoC() {
    }

    public static void main(String[] args) {
        System.out.println("Memento:");
        MementoDemo.run();
        System.out.println("\nObserver:");
        ObserverDemo.run();
        System.out.println("\nState:");
        StateDemo.run();
        System.out.println("\nStrategy:");
        StrategyDemo.run();
        System.out.println("\nTemplate Method:");
        TemplateMethodDemo.run();
        System.out.println("\nVisitor:");
        VisitorDemo.run();
    }
}
