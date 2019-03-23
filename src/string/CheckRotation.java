package string;

public class CheckRotation {

    public static void main(String[] args) {
        isRotation("ninja", "janin");
        isRotation("ninja", "ajnin");
    }

    private static void isRotation(String s1, String s2) {
        s1 = s1 + s1;
        if (s1.indexOf(s2) != -1) {
            System.out.println("Rotation");
        } else {
            System.out.println("Not rotation");
        }
    }
}
