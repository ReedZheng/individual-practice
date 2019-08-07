package practicecourt.offer;

import org.junit.Test;

import java.util.ArrayList;

public class Off032Test {

    @Test
    public void getLeastNumbersSolution() {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> list = new Off032().getLeastNumbersSolution(arr, 4);
        System.out.println(list);
    }

}