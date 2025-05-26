import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println("Enter ID and name (0 to stop):");
        while (true) {
            int id = sc.nextInt();
            if (id == 0) break;
            String name = sc.next();
            map.put(id, name);
        }
        System.out.print("Enter ID to search: ");
        int search = sc.nextInt();
        System.out.println("Name: " + map.get(search));
    }
}
