package operators;

public class Multiplication implements Operator {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }

    @Override
    public int level() {
        return 1;
    }
}
