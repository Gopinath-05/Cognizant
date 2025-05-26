public class JavapDemo {
    public int square(int x) { return x * x; }
    public static void main(String[] args) {
        System.out.println(new JavapDemo().square(5));
    }
}
// Compile and run: javap -c JavapDemo
