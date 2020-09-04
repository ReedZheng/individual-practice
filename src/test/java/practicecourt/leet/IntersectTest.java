package practicecourt.leet;

import junit.framework.TestCase;

public class IntersectTest extends TestCase {

    public void testIntersect() {
        int[] result = new Intersect()
            .intersect(new int[]{3, 1, 2},
                new int[]{1, 1});
        for (int i : result) {
            System.out.print(i + ", ");
        }
    }
}