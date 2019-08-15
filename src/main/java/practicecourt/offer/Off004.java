package practicecourt.offer;

import lombok.extern.slf4j.Slf4j;

/**
 * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。 因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，
 * 当前元素的查找区间为左下角的所有元素。
 */
@Slf4j
public class Off004 {

    public void find(int[][] arr, int target) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return;
        }
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0, j = col - 1; i < row && j >= 0; ) {
            if (target == arr[i][j]) {
                log.info("找到该数, i = {}, j = {}", i, j);
                break;
            } else if (target > arr[i][j]) {
                i++;
            } else {
                j--;
            }
        }
    }

    // from github
    public boolean find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}
