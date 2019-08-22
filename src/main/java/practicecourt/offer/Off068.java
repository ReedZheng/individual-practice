package practicecourt.offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bccced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
public class Off068 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int mLength = matrix.length;
        if (mLength <= 0 || str.length <= 0) {
            return false;
        }

        boolean[] arr = new boolean[mLength];
        boolean result = false;

        // 在 matrix 数组中找到与 str 数组的第一个元素相等的元素，然后开始试探。
        for (int i = 0; i < mLength; i++) {
            if (matrix[i] == str[0]) {
                result |= dfs(matrix, i, str, 0, cols, arr);
                arr = new boolean[mLength];
            }
        }

        return result;
    }

    /**
     * i - 列数   往上走
     * i + 1     往右走
     * i + 列数   往下走
     * i - 1     往左走
     *
     * @param matrix
     * @param mIndex
     * @param str
     * @param sIndex
     */
    private boolean dfs(char[] matrix, int mIndex, char[] str, int sIndex, int cols, boolean[] arr) {
        boolean result = false;

        // 如果不相等则回到上一步
        if (matrix[mIndex] == str[sIndex]) {
            arr[mIndex] = true;

            if (sIndex == str.length - 1) {
                return true;
            }

            // 最前边的大小判断是判断有没有越界，因为是当成一维数组来操作的，因此只要保证变化后的数组下标在 0 <= len < matrix.length 即可
            // !result 当 result = true 时说明找到路径，此时 !result == false 可以在回溯的情况下不做其他方向的判断
            // !arr[xxx] 表示先判断下一个位置是否已经走过，若走过则放弃选择该方向

            // 上
            if (mIndex - cols >= 0 && !arr[mIndex - cols]) {
                result = dfs(matrix, mIndex - cols, str, sIndex + 1, cols, arr);
            }
            // 右
            if (mIndex + 1 < matrix.length && !result && !arr[mIndex + 1]) {
                result = dfs(matrix, mIndex + 1, str, sIndex + 1, cols, arr);
            }
            // 下
            if (mIndex + cols < matrix.length && !result && !arr[mIndex + cols]) {
                result = dfs(matrix, mIndex + cols, str, sIndex + 1, cols, arr);
            }
            // 左
            if (mIndex - 1 >= 0 && !result && !arr[mIndex - 1]) {
                result = dfs(matrix, mIndex - 1, str, sIndex + 1, cols, arr);
            }

        }

        return result;

    }
}



