package practicecourt.offer;

import org.junit.Test;

public class Off043Test {

    @Test
    public void findNumsAppearOnce() {
        int[] a = new int[1];
        int[] b = new int[1];
        new Off043().findNumsAppearOnce2(new int[]{2, 4, 3, 6, 3, 2, 5, 5}, a, b);
        System.out.println(a[0]);
        System.out.println(b[0]);
    }
}