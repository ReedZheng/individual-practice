package practicecourt.offer;

import org.junit.Test;

public class Off040Test {

    @Test
    public void getNumberOfK() {
        int[] arr = new int[] {3, 6, 8, 8, 8, 9, 82};
        int k = 8;
        int numberOfK = new Off040().getNumberOfK(arr, k);
        System.out.println(numberOfK);
    }
}