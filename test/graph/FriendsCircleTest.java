package graph;

import org.junit.Assert;
import org.junit.Test;

import static graph.FriendsCircle.numberOfFriendsCircle;

public class FriendsCircleTest {
    @Test
    public void checkCircle() {
        String[] friends = {
                "YNNNN",
                "NYNNN",
                "NNYNN",
                "NNNYN",
                "NNNNY"
        };
        Assert.assertEquals(5, numberOfFriendsCircle(friends));
    }

    @Test
    public void checkCircle2() {
        String[] friends = {
                "YNNNY",
                "NYNNN",
                "NNYNN",
                "NNNYN",
                "NNNNY"
        };
        Assert.assertEquals(4, numberOfFriendsCircle(friends));
    }

    @Test
    public void checkCircle3() {
        String[] friends = {
                "YNNNYNY",
                "NYNNNYY",
                "NNYNNNN",
                "NNNYNNN",
                "YNNNYNN",
                "NYNNNYN",
                "YYNNNNY"
        };
        Assert.assertEquals(3, numberOfFriendsCircle(friends));
    }

}