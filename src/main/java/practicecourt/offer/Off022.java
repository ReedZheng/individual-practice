package practicecourt.offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵：1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字：1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 矩阵不一定是正方形的！！！
 */
public class Off022 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int rowLength = 0, colLength = 0;
        int loopCount = 0;

        if (matrix != null) {
            rowLength = matrix.length;
            if (matrix[0] != null) {
                colLength = matrix[0].length;
            }
            // from 牛客
            loopCount = ((rowLength < colLength ? rowLength : colLength) - 1) / 2 + 1;
        } else {
            return null;
        }

        int leftLimit = 0, rightLimit = colLength - 1, upLimit = 0, downLimit = rowLength - 1;

        for (int i = 0; i < loopCount; i++) {
            // 右
            for (int j = leftLimit; j <= rightLimit; j++) {
                list.add(matrix[upLimit][j]);
            }
            // 下
            for (int j = upLimit + 1; j <= downLimit; j++) {
                list.add(matrix[j][rightLimit]);
            }
            // 左，至少是两行时才允许向左
            for (int j = rightLimit - 1; j >= leftLimit && downLimit > upLimit; j--) {
                list.add(matrix[downLimit][j]);
            }
            // 上，至少是两列时才允许向上
            for (int j = downLimit - 1; j > upLimit && rightLimit > leftLimit; j--) {
                list.add(matrix[j][leftLimit]);
            }

            leftLimit++;
            rightLimit--;
            upLimit++;
            downLimit--;
        }

        return list;
    }
}


