import exception.InvalidExpressionException;
import operators.Addition;
import operators.Division;
import operators.Multiplication;
import operators.Operator;
import operators.Subtraction;

public class OperatorFactory {

    public Operator with(char symbol) throws InvalidExpressionException {
        if(symbol=='+')
            return new Addition();
        else if(symbol=='-')
            return new Subtraction();
        else if(symbol=='*')
            return new Multiplication();
        else if(symbol=='/')
            return new Division();
        else
            throw new InvalidExpressionException("Invalid operator provided");
    }
}
