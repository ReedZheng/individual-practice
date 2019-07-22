package offer;

import org.junit.Test;
import practicecourt.offer.Off004;

public class Off004Test {

    int[][] arrs =
        {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 20}, {7, 8, 9, 16, 22}, {10, 13, 14, 19, 24}, {19, 21, 23, 26, 30}};

    @Test
    public void existOrNot() {
        new Off004().existOrNot(arrs, 2);
    }

    @Test
    public void find() {
        new Off004().existOrNot(arrs, 26);
    }
}
