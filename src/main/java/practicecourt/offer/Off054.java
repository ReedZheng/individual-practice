package practicecourt.offer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1], 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 题目的意思是： 当B0时，    B0   = A1*A2*A3*A4*..An-2*An-1（没有A[0]） 当B1时，    B1   =
 * A0*A1*A2*A3*..An-2*An-1（没有A[1]） 当B2时，    B2   = A0*A1*A3*A4*..An-2*An-1（没有A[2]） 当B3时，    B3   =
 * A0*A1*A2*A4*..An-2*An-1（没有A[3]） 当Bn-1时，  Bn-1 = A0*A1*A2*A3*..An-2     （没有A[n-1]）
 */
public class Off054 {

    public int[] multiply(int[] a) {
        int length = a.length;
        if (length <= 0) {
            return new int[0];
        }

        int[] b = new int[length];
        for (int i = 0; i < length; i++) {
            b[i] = 1;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                b[i] *= a[j];
            }
            for (int k = i + 1; k < length; k++) {
                b[i] *= a[k];
            }
        }

        return b;
    }

    /**
     * from 牛客
     *
     * @param A
     * @return
     */
    public int[] multiply2(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            // 计算下三角连乘
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }

            int temp = 1;
            // 计算上三角
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }
}
