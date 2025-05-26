public class VirtualThreadsDemo {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100_000; i++) {
            Thread.startVirtualThread(() -> System.out.println("Hello from virtual thread"));
        }
        Thread.sleep(1000);
    }
}
