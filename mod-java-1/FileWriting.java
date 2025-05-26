import java.io.*;
import java.util.Scanner;

public class FileWriting {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write(text);
        }
        System.out.println("Written to output.txt");
    }
}
