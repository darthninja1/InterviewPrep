package recursive;/* Problem Name is &&& Optimal Path &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
 ** Instructions to candidate.
 **  1) You are an avid rock collector who lives in southern California. Some rare
 **     and desirable rocks just became available in New York, so you are planning
 **     a cross-country road trip. There are several other rare rocks that you could
 **     pick up along the way.
 **
 **     You have been given a grid filled with numbers, representing the number of
 **     rare rocks available in various cities across the country.  Your objective
 **     is to find the optimal path from So_Cal to New_York that would allow you to
 **     accumulate the most rocks along the way.
 **
 **     Note: You can only travel either north (up) or east (right).
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement optimalPath() correctly.
 **  4) Here is an example:
 **                                                           ^
 **                 {{0,0,0,0,5}, New_York (finish)           N
 **                  {0,1,1,1,0},                         < W   E >
 **   So_Cal (start) {2,0,0,0,0}}                             S
 **                                                           v
 **   The total for this example would be 10 (2+0+1+1+1+0+5).
 */
class OptimalPath {
    /*
     **  Find the optimal path.
     */
    public static Integer optimalPath(Integer[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int col = 0;
        int row = grid.length - 1;
        return optimalPathHelper(grid, row, col, 0);
    }

    public static Integer optimalPathHelper(Integer[][] grid, int row, int col, int count) {
        if (row < 0 || col >= grid[0].length) {
            // abort
            return -1;
        }

        if (row == 0 && col == grid[0].length - 1) {
            return count + grid[row][col];
        }

        // north
        int rocks1 = 0;
        rocks1 = optimalPathHelper(grid, row - 1, col, count + grid[row][col]);

        // east
        int rocks2 = 0;
        rocks2 = optimalPathHelper(grid, row, col + 1, count + grid[row][col]);

        return Math.max(rocks1, rocks2);
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        boolean result = true;
        // Base test case
        result &= optimalPath(new Integer[][]{{0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}}) == 10;

        result &= optimalPath(new Integer[][]{{0, 0, 0, 0, 5}}) == 5;

        result &= optimalPath(new Integer[][]{{0}, {0}, {0}, {0}, {5}}) == 5;

        result &= optimalPath(new Integer[][]{{1, 0, 0, 0, 5},
                {3, 1, 1, 1, 0},
                {2, 0, 0, 0, 9}}) == 16;

        result &= optimalPath(new Integer[][]{{6, 0, 0, 0, 5},
                {3, 1, 1, 1, 0},
                {2, 0, 0, 0, 9}}) == 16;

        result &= optimalPath(null) == 0;

        result &= optimalPath(new Integer[0][100]) == 0;

        result &= optimalPath(new Integer[100][0]) == 0;

        return result;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}