package practicecourt.offer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * <p>
 * 两个条件：1. 每次只能在上下左右走一格；2.行坐标和列坐标的数位之和小于等于 k
 */
public class Off069 {
    int count = 0;

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }

        boolean[][] arr = new boolean[rows][cols];

        dfs(0, 0, rows, cols, threshold, arr);

        return count;
    }

    private void dfs(int i, int j, int rows, int cols, int threshold, boolean[][] arr) {
        if (i > rows - 1 || j > cols - 1) {
            return;
        }

        if (canMatch(i, j, threshold) && !arr[i][j]) {
            arr[i][j] = true;
            count++;
        } else {
            return;
        }

        // 上
        if (i - 1 >= 0) {
            dfs(i - 1, j, rows, cols, threshold, arr);
        }
        // 右
        if (j + 1 < cols) {
            dfs(i, j + 1, rows, cols, threshold, arr);
        }
        // 下
        if (i + 1 < rows) {
            dfs(i + 1, j, rows, cols, threshold, arr);
        }
        // 左
        if (j - 1 >= 0) {
            dfs(j - 1, j, rows, cols, threshold, arr);
        }

    }

    private boolean canMatch(int first, int second, int threhold) {
        int sum = 0;

        while (first != 0) {
            sum += first % 10;
            first /= 10;
        }

        while (second != 0) {
            sum += second % 10;
            second /= 10;
        }

        return sum <= threhold;
    }
}

