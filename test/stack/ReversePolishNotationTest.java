package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static stack.ReversePolishNotation.computeRPN2;
import static stack.ReversePolishNotation.registerOperator;

public class ReversePolishNotationTest {
    static HashMap<String, ReversePolishNotation.RPNOperator> map = new HashMap<>();

    @Before
    public void setup() {
        registerOperator(new ReversePolishNotation.Add());
        registerOperator(new ReversePolishNotation.Subtract());
        registerOperator(new ReversePolishNotation.Multiply());
        registerOperator(new ReversePolishNotation.Divide());
    }

    @Test(expected = RuntimeException.class)
    public void testError() {
        computeRPN2(null);
    }

    @Test(expected = RuntimeException.class)
    public void testError2() {
        computeRPN2(new String[0]);
    }

    @Test
    public void testUnary() {
        Assert.assertEquals(-2, computeRPN2(new String[]{"2", "-"}));
    }

    @Test(expected = RuntimeException.class)
    public void testDivideByZero() {
        computeRPN2(new String[]{"0", "3", "/"});
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(0, computeRPN2(new String[]{"3", "0", "/"}));
    }

    @Test
    public void testRPN() {
        String[] arr = new String[]{"1", "2", "+", "4", "*"};

        Assert.assertEquals(3, computeRPN2(new String[]{"2", "3", "*", "18", "/"}));
    }

    @Test
    public void testRPN2() {
        Assert.assertEquals(12, computeRPN2(new String[]{"1", "2", "+", "4", "*"}));
    }
}