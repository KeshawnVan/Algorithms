package algorithm.calculate;

import org.junit.jupiter.api.Test;

public class TestCalculate {

    private String expression = "a + b * c + (d * e + f) * g";

    @Test
    public void testInfix2Postfix() {
        System.out.println(InfixToPostfix.cast(expression));
    }
}
