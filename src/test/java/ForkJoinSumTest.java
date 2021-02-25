import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sum.ForkJoinSum;
import sum.ListUtil;

public class ForkJoinSumTest {
    private static List<Integer> list;
    private static int checkSum;
    private static ForkJoinSum forkJoinSum;

    @BeforeAll
    public static void initialize() {
        list = ListUtil.generate();
        forkJoinSum = new ForkJoinSum(list);
        checkSum = list.stream()
                .reduce(0, Integer::sum);
    }

    @Test
    public void calculateSum_OK() {
        Assertions.assertEquals(checkSum, forkJoinSum.sum());
    }
}
