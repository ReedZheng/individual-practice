package practicecourt.offer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class Off003Test {

    int[][] arrs =
        {{1, 2, 1, 0, 4, 2}, {0, 5, 4, 4, 1, 2}, {5, 3, 1, 6, 2, 5, 4}, {7, 7, 5, 4, 1, 2, 1, 2}, {3, 2, 3, 1},
            {4, 3, 2, 0, 1}, {6, 2, 1, 2, 2, 4, 5, 7}, {3, 0, 3, 3}, {2, 3, 1, 0, 2, 0}, {1, 3, 2, 0, 0, 2, 5, 3}};

    @Test
    public void resolve() {

        for (int[] arr : arrs) {
            int result = new Off003().resolve(arr);
            if (result != -1) {
                log.info("找到的重复数字是：{}", result);
            }
        }
    }

    @Test
    public void duplicate() {
        for (int[] arr : arrs) {
            new Off003().duplicate(arr, arr.length, new int[1]);
        }
    }
}
