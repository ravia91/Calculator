package operators;

public class Division implements Operator {
    @Override
    public double calculate(double a, double b) {
        return  b/a;
    }

    @Override
    public int level() {
        return 1;
    }
}
