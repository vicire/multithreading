package sum;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;

public class ExecutorServiceSum {
    private static final int THREADS = 10;
    private final List<Integer> digits;

    public ExecutorServiceSum(List<Integer> digits) {
        this.digits = digits;
    }

    public Integer calculate() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        List<List<Integer>> partThread = ListUtils.partition(digits, digits.size() / THREADS);
        List<Callable<Integer>> myCallables = partThread.stream()
                .map(SumCallable::new)
                .collect(Collectors.toList());
        try {
            executorService.invokeAll(myCallables);
            int sum = 0;
            for (Callable<Integer> thread : myCallables) {
                sum += executorService.submit(thread).get();
            }
            executorService.shutdown();
            return sum;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("An error was occurred", e);
        }
    }
}
