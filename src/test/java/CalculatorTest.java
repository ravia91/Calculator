import exception.InvalidExpressionException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2+3:5"
            ,"2.6+3.2:5.8"
            ,"2.2/1.5:1.46"
            ,"2*3:6"
            ,"1/2:0.5"
            ,"4*2+8:16"
            ,"4*(2+8):40"
            ,"4*(2/8):1"
            ,"4*(6/3+2):16"
            ,"4*(2+3)+((6+1)*2):34"
    }, delimiter = ':')
    void shoulCalculateFromExpression(String input, double output) throws InvalidExpressionException {
        Calculator calc = new Calculator(input);
        double evaluate = calc.evaluate();
        assertEquals(output, evaluate, 0.01);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2+3):Invalid operator provided"
            ,"*(2+3):more number of operators added"
            ,"4*(2+3)-:more number of operators added"
            ,"4*(2+3)-)):Invalid operator provided"
    }, delimiter = ':')
    void shouldThrowExceptionForInvalidExpr(String input, String expectedOp){
        InvalidExpressionException thrown = assertThrows(
                InvalidExpressionException.class,
                () -> new Calculator(input).evaluate(),
                "Expected doThing() to throw, but it didn't"
        );

        assertTrue(thrown.getMessage().contains(expectedOp));
    }
}
