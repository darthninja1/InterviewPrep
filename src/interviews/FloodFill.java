package interviews;

// https://www.techiedelight.com/flood-fill-algorithm/
public class FloodFill {
    public static void main(String[] args) {
        Pixel[][] grid = new Pixel[10][10];
        initialize(grid);
        fillFlood(grid[0][0], 1, 0);
        validate(grid, 1);
        for (int i = 0; i < grid.length; i++) {
            grid[i][i].color = 2;
        }
        fillFlood(grid[1][0], 3, 1);
        validate2(grid, 1, 3, 2);
        fillFlood(grid[0][1], 4, 1);
        validate2(grid, 4, 3, 2);
    }

    private static void validate2(Pixel[][] grid, int oldColor, int expectedColor, int diagonalColor) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j].color + " ");
                if (i == j && grid[i][j].color != diagonalColor) {
                    throw new RuntimeException("error");
                } else if (i > j && grid[i][j].color != expectedColor) {
                    throw new RuntimeException("error");
                } else if (i < j && grid[i][j].color != oldColor) {
                    throw new RuntimeException("error");
                }
            }
            System.out.println();
        }
        System.out.println("success");
    }

    private static void validate(Pixel[][] grid, int expectedColor) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j].color + " ");
                if (grid[i][j].color != expectedColor) {
                    throw new RuntimeException("error");
                }
            }
            System.out.println();
        }
        System.out.println("success");
    }

    private static void initialize(Pixel[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Pixel p = new Pixel();
                grid[i][j] = p;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Pixel p = grid[i][j];
                if (i > 0) {
                    p.up = grid[i - 1][j];
                }
                if (j > 0) {
                    p.left = grid[i][j - 1];
                }
                if (i < grid.length - 1) {
                    p.down = grid[i + 1][j];
                }
                if (j < grid[0].length - 1) {
                    p.right = grid[i][j + 1];
                }
            }
        }
    }

    private static void fillFlood(Pixel clicked, int newColor, int oldColor) {
        if (clicked.color == oldColor) {
            clicked.color = newColor;
            fillFloodUtil(clicked.up, newColor, oldColor);
            fillFloodUtil(clicked.down, newColor, oldColor);
            fillFloodUtil(clicked.right, newColor, oldColor);
            fillFloodUtil(clicked.left, newColor, oldColor);
        }
    }

    private static void fillFloodUtil(Pixel px, int newColor, int oldColor) {
        if (px != null && px.color != newColor) {
            fillFlood(px, newColor, oldColor);
        }
    }

    private static final class Pixel {
        Pixel up;
        Pixel down;
        Pixel right;
        Pixel left;
        int color;
    }


}
