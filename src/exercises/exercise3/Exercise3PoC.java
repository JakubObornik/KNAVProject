package exercises.exercise3;

import exercises.exercise3.patterns.chainofresponsibility.ChainOfResponsibilityDemo;
import exercises.exercise3.patterns.command.CommandDemo;
import exercises.exercise3.patterns.interpreter.InterpreterDemo;
import exercises.exercise3.patterns.iterator.IteratorDemo;
import exercises.exercise3.patterns.mediator.MediatorDemo;
import exercises.exercise3.patterns.proxy.ProxyDemo;

/** Runs all design pattern demonstrations from practical block 3. */
public final class Exercise3PoC {

    private Exercise3PoC() {
    }

    public static void main(String[] args) {
        System.out.println("Chain of Responsibility:");
        ChainOfResponsibilityDemo.run();
        System.out.println("\nCommand:");
        CommandDemo.run();
        System.out.println("\nInterpreter:");
        InterpreterDemo.run();
        System.out.println("\nIterator:");
        IteratorDemo.run();
        System.out.println("\nMediator:");
        MediatorDemo.run();
        System.out.println("\nProxy:");
        ProxyDemo.run();
    }
}
