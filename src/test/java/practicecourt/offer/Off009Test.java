package practicecourt.offer;

import org.junit.Test;

public class Off009Test {

    int[] array = {1, 0, 1, 1, 1, 1, 1};

    @Test
    public void minNumberInRotateArray() {
        int result = new Off009().minNumberInRotateArray(array);
        System.out.println(result);
    }
}