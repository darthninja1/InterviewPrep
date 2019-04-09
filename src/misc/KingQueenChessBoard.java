package misc;

// https://www.geeksforgeeks.org/check-if-a-queen-can-attack-a-given-cell-on-chessboard/
public class KingQueenChessBoard {
    public static void main(String[] args) {
        System.out.println(canAttack(4, 2, 6, 5));
        System.out.println(canAttack(4, 2, 4, 5));
        System.out.println(canAttack(4, 2, 8, 2));
        System.out.println(canAttack(2, 2, 8, 8));
        System.out.println(canAttack(2, 2, 8, 7));
    }

    private static boolean canAttack(int kingX, int kingY, int queenX, int queenY) {
        check(kingX);
        check(kingY);
        check(queenX);
        check(queenY);

        // same row or column
        if (kingX == queenX || kingY == queenY) {
            return true;
        }
        // diagonal - slope == 1 i.e. 45 degree angle
        if (Math.abs(kingX - queenX) == Math.abs(kingY - queenY)) {
            return true;
        }
        return false;
    }

    private static void check(int pos) {
        assert pos > 1 && pos <= 8;
    }
}
