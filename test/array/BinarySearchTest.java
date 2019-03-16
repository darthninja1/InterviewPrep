package array;

import org.junit.Assert;
import org.junit.Test;

import static array.BinarySearch.search;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        Assert.assertEquals(4, search(array, 5));
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        Assert.assertEquals(-1, search(array, 8));
    }

}