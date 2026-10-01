package exercises.exercise3.patterns.interpreter;

/** Evaluates arithmetic expressions represented as an expression tree. */
public final class InterpreterDemo {

    private InterpreterDemo() {
    }

    public static void run() {
        Expression fivePlusThree = new AddExpression(new NumberExpression(5), new NumberExpression(3));
        Expression expression = new SubtractExpression(fivePlusThree, new NumberExpression(2));
        System.out.println("5 + 3 - 2 = " + expression.interpret());
    }

    private interface Expression {
        int interpret();
    }

    private record NumberExpression(int value) implements Expression {
        public int interpret() { return value; }
    }

    private record AddExpression(Expression leftExpression, Expression rightExpression) implements Expression {
        public int interpret() { return leftExpression.interpret() + rightExpression.interpret(); }
    }

    private record SubtractExpression(Expression leftExpression, Expression rightExpression) implements Expression {
        public int interpret() { return leftExpression.interpret() - rightExpression.interpret(); }
    }
}
