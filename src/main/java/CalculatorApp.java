import exception.InvalidExpressionException;

public class CalculatorApp {

    public static void main(String args[]) throws InvalidExpressionException {
        Calculator c = new Calculator(args[0]);
        System.out.println(c.evaluate());
    }
}
