package algorithm.calculate;

import org.junit.jupiter.api.Test;

public class TestCalculate {

    @Test
    public void testInfix2Postfix() {
        String expression = "a + b * c + (d * e + f) * g";
        System.out.println(InfixToPostfix.cast(expression));
    }

    @Test
    public void testPostfixExpressionCalculate() {
        String expression = "1 + 2 * 4";
        System.out.println(PostfixExpressionCalculate.calculate(InfixToPostfix.cast(expression)));

        System.out.println(PostfixExpressionCalculate.calculateWithInfix("2 + (5 + 1 * 4 ) - 2 / 2"));
    }
}
