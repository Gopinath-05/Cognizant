import java.util.*;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("banana", "apple", "pear");
        list.sort((a, b) -> a.compareTo(b));
        System.out.println(list);
    }
}
