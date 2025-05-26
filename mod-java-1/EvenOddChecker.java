import java.util.Scanner;

public class EvenOddChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        System.out.println(n + (n % 2 == 0 ? " is even." : " is odd."));
    }
}
