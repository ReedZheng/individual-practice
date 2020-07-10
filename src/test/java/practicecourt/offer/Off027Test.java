package practicecourt.offer;

import java.util.ArrayList;
import org.junit.Test;

public class Off027Test {

    @Test
    public void findPath() {
        Off027 off027 = new Off027();
        ArrayList<ArrayList<Integer>> list = off027.findPath(off027.node0, 31);
        for (ArrayList<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}