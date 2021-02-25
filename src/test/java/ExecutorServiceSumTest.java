import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sum.ExecutorServiceSum;
import sum.ListUtil;

public class ExecutorServiceSumTest {
    private static List<Integer> list;
    private static int checkSum;
    private static ExecutorServiceSum executorServiceSum;

    @BeforeAll
    public static void initialize() {
        list = ListUtil.generate();
        executorServiceSum = new ExecutorServiceSum(list);
        checkSum = list.stream()
                .reduce(0, Integer::sum);
    }

    @Test
    public void calculateSum_OK() {
        Assertions.assertEquals(checkSum, executorServiceSum.calculate());
    }
}
