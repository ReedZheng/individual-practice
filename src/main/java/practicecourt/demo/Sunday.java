package practicecourt.demo;

import java.math.BigDecimal;

/**
 * @author: zhengfenghong
 * @date: 2020/8/10 16:34
 */
public class Sunday {
    public static int getIndex(String pat, Character c) {
        for (int i = pat.length() - 1; i >= 0; i--) {
            if (pat.charAt(i) == c)
                return i;
        }
        return -1;
    }

    public static int SundaySearch(String txt, String pat) {
        int M = txt.length();
        int N = pat.length();
        int i, j;
        int skip = -1;
        for (i = 0; i <= M - N; i += skip) {
            for (j = 0; j < N; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)){
                    if (i == M - N)
                        break;
                    skip = N - getIndex(pat, txt.charAt(i + N));
                    break;
                }
            }
            if (j == N)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        // String txt = "BBC ABCDAB AACDABABCDABCDABD";
        // String pat = "ABCDABD";
        // System.out.println(SundaySearch(txt, pat));

        BigDecimal value = BigDecimal.ZERO.add(new BigDecimal("-1"));
        System.out.println(value);
    }
}
