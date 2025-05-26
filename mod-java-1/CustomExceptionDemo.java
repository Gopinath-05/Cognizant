import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) { super(msg); }
}
public class CustomExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        try {
            if (age < 18) throw new InvalidAgeException("Age less than 18");
            System.out.println("Valid age.");
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
