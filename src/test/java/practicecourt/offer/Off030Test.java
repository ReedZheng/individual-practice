package practicecourt.offer;

import java.util.ArrayList;
import org.junit.Test;

public class Off030Test {

    @Test
    public void permutation() {
        ArrayList<String> list = new Off030().permutation("abcd");
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}

