package sum;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;

public class ExecutorServiceSum {
    public static final int THREADS = 10;
    private final List<Integer> digits;

    public ExecutorServiceSum(List<Integer> digits) {
        this.digits = digits;
    }

    public Integer calculate() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        List<List<Integer>> partThread = ListUtils.partition(digits, digits.size() / THREADS);
        List<MyCallable> myCallables = partThread.stream()
                .map(MyCallable::new)
                .collect(Collectors.toList());
        try {
            executorService.invokeAll(myCallables);
            int sum = 0;
            for (MyCallable thread : myCallables) {
                sum += executorService.submit(thread).get();
            }
            return sum;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("An error was occurred", e);
        } finally {
            executorService.shutdown();
        }
    }
}
