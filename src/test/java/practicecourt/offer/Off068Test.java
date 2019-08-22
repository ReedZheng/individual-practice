package practicecourt.offer;

import org.junit.Test;

public class Off068Test {

    @Test
    public void hasPath() {
        // ABCESFCSADEE, 3, 4, SEE
        char[] a = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] b = "SGGFIECVAASABCEHJIGQEM".toCharArray();

        boolean result = new Off068().hasPath(a, 5, 8, b);

        System.out.println(result);
    }
}