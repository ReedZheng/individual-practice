package practicecourt.offer.basicstruct;

import org.junit.Test;

public class MinHeapTest {

    @Test
    public void build() {
        int[] arr = {4, 5, 9, 8, 4, 8, 9, 7, 11, 2, 3, 4, 7};
        new MinHeap(arr).build();
    }
}