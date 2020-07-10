package practicecourt.offer;

import java.util.ArrayList;
import org.junit.Test;

public class Off022Test {

    int[][] arrs =
        {{1}, {2}, {3}, {4}, {5}};
    // {{1, 2, 3, 4, 5}};
    // {{2, 3, 6, 3}, {9, 0, 1, 2}};
    // {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 20}, {7, 8, 9, 16, 22}};
    // {{1, 4, 7}, {2, 5, 8}, {7, 8, 9}, {10, 13, 14}, {19, 21, 23}};

    @Test
    public void printMatrix() {
        ArrayList<Integer> list = new Off022().printMatrix(arrs);
        for (Integer i : list) {
            System.out.print(i + " ");
        }

    }
}