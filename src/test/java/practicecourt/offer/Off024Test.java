package practicecourt.offer;

import org.junit.Test;

public class Off024Test {

    int[] pushA = {};
    int[] popA = {};

    @Test
    public void isPopOrder() {
        boolean result = new Off024().isPopOrder(pushA, popA);
        System.out.println(result);
    }
}