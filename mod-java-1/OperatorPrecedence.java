public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result + " (Multiplication before addition)");
        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2 + " (Parentheses first)");
    }
}
