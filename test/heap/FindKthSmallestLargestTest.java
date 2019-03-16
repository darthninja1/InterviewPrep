package heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static heap.FindKthSmallestLargest.findKthLargest;
import static heap.FindKthSmallestLargest.findKthSmallest;

public class FindKthSmallestLargestTest {

    @Test
    public void testKthSmallest() {
        Assert.assertEquals(8, findKthSmallest(Arrays.asList(new Integer[]{3, 4, 5, 1, 6, 2, 8}), 7));
    }

    @Test
    public void testKthLargest() {
        Assert.assertEquals(1, findKthLargest(Arrays.asList(new Integer[]{3, 4, 5, 1, 6, 2, 8}), 7));
    }
}