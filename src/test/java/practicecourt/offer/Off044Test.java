package practicecourt.offer;

import java.util.ArrayList;
import org.junit.Test;

public class Off044Test {

    @Test
    public void findContinuousSequence() {
        ArrayList<ArrayList<Integer>> lists = new Off044().findContinuousSequence(18);
        for (ArrayList<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}