import java.util.concurrent.*;
import java.util.*;

public class ExecutorServiceCallable {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> tasks = Arrays.asList(
            () -> 1+1, () -> 2+2, () -> 3+3
        );
        List<Future<Integer>> results = es.invokeAll(tasks);
        for (Future<Integer> f : results)
            System.out.println(f.get());
        es.shutdown();
    }
}
