import exception.InvalidExpressionException;
import operators.Operator;

import java.util.EmptyStackException;
import java.util.Stack;

public class Calculator {

    private final String expr;
    Stack<Double> values;
    Stack<Operator> operators;
    OperatorFactory factory;

    public Calculator(String expr){
        this.expr = expr;
        factory = new OperatorFactory();
        values = new Stack<>();
        operators = new Stack<>();
    }

    public double evaluate() throws InvalidExpressionException {

        try {

            for (int i = 0; i < expr.length(); i++) {
                char current = expr.charAt(i);
                if (current >= '0' && current <= '9') {
                    StringBuilder builder = new StringBuilder();
                    builder.append(current);
                    i++;
                    while (i < expr.length() && ((expr.charAt(i) >= '0' && expr.charAt(i) <= '9') || expr.charAt(i) == '.')) {
                        builder.append(expr.charAt(i++));
                    }
                    i--;
                    values.add(Double.parseDouble(builder.toString()));
                } else if (current == '(') {
                    int openbraces = 1;
                    StringBuilder builder = new StringBuilder();
                    i++;
                    while (i < expr.length() && openbraces > 0) {
                        if (expr.charAt(i) == '(') {
                            openbraces++;
                        }
                        if (expr.charAt(i) == ')') {
                            openbraces--;
                        }
                        if (openbraces >= 1)
                            builder.append(expr.charAt(i++));
                    }
                    values.push(new Calculator(builder.toString()).evaluate());
                } else {
                    Operator operator = factory.with(current);
                    while (!operators.isEmpty() && operator.level() >= operators.peek().level()) {
                        double compute = operators.pop().calculate(values.pop(), values.pop());
                        values.add(compute);
                    }

                    operators.add(operator);
                }
            }

            while (!operators.isEmpty()) {
                double compute = operators.pop().calculate(values.pop(), values.pop());
                values.add(compute);
            }

            return values.pop();
        }catch (EmptyStackException e){
            throw new InvalidExpressionException("more number of operators added", e);
        }

    }

}
