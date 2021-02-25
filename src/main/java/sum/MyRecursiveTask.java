package sum;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    private final List<Integer> list;

    public MyRecursiveTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        return list.stream().reduce(0, Integer::sum);
    }
}
