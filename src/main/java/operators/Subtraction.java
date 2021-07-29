package operators;

public class Subtraction implements Operator {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }

    @Override
    public int level() {
        return 2;
    }
}
