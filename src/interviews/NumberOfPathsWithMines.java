package interviews;

// 0 means mine
public class NumberOfPathsWithMines {
    public static void main(String[] args) {
        int[][] mines = new int[][]{
                {1, 1},
                {1, 1},
        };
        System.out.println(paths(mines, 0, 0));
        int[][] mines2 = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
        };
        System.out.println(paths(mines2, 0, 0));
    }

    private static int paths(int[][] mines, int row, int col) {
        if (row == mines.length - 1 && col == mines[0].length - 1) {
            return 1;
        }
        if (row >= mines.length || col >= mines[0].length) {
            return 0;
        }
        int south = 0;
        if (row <= mines.length - 2 && mines[row + 1][col] != 0) {
            south = paths(mines, row + 1, col);
        }
        int east = 0;
        if (col <= mines[0].length - 2 && mines[row][col + 1] != 0) {
            east = paths(mines, row, col + 1);
        }
        return east + south;
    }
}