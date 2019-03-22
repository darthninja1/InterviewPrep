package bits;

// https://www.geeksforgeeks.org/add-1-to-a-given-number/
// https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
public class AddOneWithoutArithmeticOperator {
    public static void main(String[] args) {
        add(10, 1);
        add(255, 1);
        add(3, 1);
    }

    private static void add(int num1, int num2) {
        while (num2 != 0) {
            System.out.println("Num1: " + num1 + ", num2: " + num2);
            int carry = num1 & num2;
            num1 = num1 ^ num2;
            num2 = carry << 1;
        }
        System.out.println(num1);
    }
}
