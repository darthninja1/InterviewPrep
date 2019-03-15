package interviews;

public class TokenBucket {
    // 10, 100ms, 11, 12...
    // acquire 5 10->5, 6
    private int tokenAddMs;
    private int bucketSize;
    private int currentTokensAvailable;
    private long previousTimestamp = System.currentTimeMillis();

    /**
     * Initializes a token bucket. A bucket gains a token every tokenAddMs, up to bucketSize.
     */
    private TokenBucket(int tokenAddMs, int bucketSize) {
        this.tokenAddMs = tokenAddMs;
        this.bucketSize = bucketSize;
        this.currentTokensAvailable = bucketSize;
        // System.out.println("Token Bucket initialized with " + bucketSize + " " + tokenAddMs + " " + previousTimestamp);
    }

    /**
     * Acquire the requested tokens or however many are available from the bucket.
     *
     * @return number of tokens acquired
     */
    private int acquireTokens(int numTokens) {

        long currentTS = System.currentTimeMillis();
        long diff = currentTS - previousTimestamp;
        int increaseTokens = (int) diff / tokenAddMs;
        // System.out.println("Diff: " + diff);
        if (increaseTokens > 0) {
            previousTimestamp = currentTS;
        }
        if (currentTokensAvailable + increaseTokens >= bucketSize) {
            currentTokensAvailable = bucketSize;
        } else {
            currentTokensAvailable += increaseTokens;
        }

        // System.out.println("Current: " + currentTokensAvailable);

        if (currentTokensAvailable - numTokens >= 0) {
            currentTokensAvailable -= numTokens;
            return numTokens;
        } else {
            int previous = currentTokensAvailable;
            currentTokensAvailable = 0;
            return previous;
        }
    }

    public static void main(String[] args) throws Exception {
        TokenBucket tb = new TokenBucket(100, 10);

        System.out.println(tb.acquireTokens(11) == 10);
        Thread.sleep(114);
        System.out.println(tb.acquireTokens(2) == 1);
        Thread.sleep(1050);
        System.out.println(tb.acquireTokens(11) == 10);
        System.out.println(tb.acquireTokens(11) == 0);
        Thread.sleep(2050);
        System.out.println(tb.acquireTokens(9) == 9);
        System.out.println(tb.acquireTokens(1) == 1);

        Thread.sleep(50);
        System.out.println(tb.acquireTokens(5));
        Thread.sleep(50);
        System.out.println(tb.acquireTokens(5));
        Thread.sleep(50);
        System.out.println(tb.acquireTokens(5));
        Thread.sleep(50);
        System.out.println(tb.acquireTokens(5));
        Thread.sleep(50);
        System.out.println(tb.acquireTokens(5));

        /*
         Extended questions
            - how would you handle concurrency - synchronized
            - if you had to support multiple token types - make currentTokensAvailable into an array
            - Time and space complexity
            - Simulate 24h window without actually sleeping for that long? Use a Timer interface using
              which we can plug in any current time
        */
    }
}
