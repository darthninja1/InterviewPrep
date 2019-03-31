package dp;

import org.junit.Assert;
import org.junit.Test;

import static dp.Knapsack.*;

public class KnapsackTest {

    @Test
    public void testKnapsackRecursive() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        Assert.assertEquals(22, maximizeRecursive(profits, weights, 7, 0));
    }

    @Test
    public void testKnapsackTopDown() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        Assert.assertEquals(22, maximizeTopDown(profits, weights, new Integer[weights.length][8], 7, 0));
    }

    @Test
    public void testKnapsackBottomUp() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        Assert.assertEquals(22, maximizeBottomUp(profits, weights, 7));
    }
}