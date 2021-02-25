package sum;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static List<Integer> generate() {
        List<Integer> elements = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            elements.add(1);
        }
        return elements;
    }
}
