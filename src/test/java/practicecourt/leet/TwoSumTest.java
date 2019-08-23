package practicecourt.leet;

import org.junit.Test;

public class TwoSumTest {

    @Test
    public void twoSum() {
        int[] arr =
            // {2, 7, 11, 15};
            // {};
            // {2, 6, 8, 4};
            // {3, 3};
            {3, 2, 4};
        int[] ints = new TwoSum().twoSum(arr, 6);

        if (ints != null) {
            for (int i : ints) {
                System.out.println(i);
            }
        }
    }
}