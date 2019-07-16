package practicecourt.arithmetic;

/**
 *
 */
public class PopSort {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 9, 40, 1, 2, 22, 32, 3};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void bubbleSort(int[] arr) {
        int i, j;

        for (i = arr.length - 1; i > 0; i--) {
            // 将a[0...i]中最大的数据放在末尾
            for (j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
