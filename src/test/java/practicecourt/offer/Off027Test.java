package practicecourt.offer;

import org.junit.Test;

import java.util.ArrayList;

public class Off027Test {

    @Test
    public void findPath() {
        Off027 off027 = new Off027();
        ArrayList<ArrayList<Integer>> list = off027.findPath(off027.node0, 22);
        for (ArrayList<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}