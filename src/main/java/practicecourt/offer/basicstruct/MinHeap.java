package practicecourt.offer.basicstruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 小顶堆
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MinHeap {

    int[] array;

    public void build() {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
        printHeap();
    }

    public void insert() {

    }

    public void delete() {

    }

    private void heapify(int i) {
        int left = getLeft(i);
        int right = getRight(i);
        int smallest = i;

        if (left < array.length && array[left] < array[smallest]) {
            smallest = left;
        }

        if (right < array.length && array[right] < array[smallest]) {
            smallest = right;
        }

        if (i == smallest) {
            return;
        }

        swap(i, smallest);

        heapify(smallest);
    }

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * i + 2;
    }

    private void swap(int originIndex, int newIndex) {
        int old = array[originIndex];
        array[originIndex] = array[newIndex];
        array[newIndex] = old;
    }

    private void printHeap() {
        int i = 0;
        for (; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
