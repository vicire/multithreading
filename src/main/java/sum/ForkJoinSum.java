package sum;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;

public class ForkJoinSum {
    private static final int THREADS = 10;
    private List<Integer> list;

    public ForkJoinSum(List<Integer> list) {
        this.list = list;
    }

    public Integer sum() {
        List<List<Integer>> partThread = ListUtils.partition(list, list.size() / THREADS);
        List<MyRecursiveTask> myRecursiveTasks = partThread.stream()
                .map(MyRecursiveTask::new)
                .collect(Collectors.toList());
        return ForkJoinTask.invokeAll(myRecursiveTasks).stream()
                .map(ForkJoinTask::join)
                .reduce(0, Integer::sum);
    }
}
