package practicecourt.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Off037 {
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() < 1) {
            return -1;
        }

        Map<String, Integer> map = new LinkedHashMap<>();
        String[] strings = str.split("");

        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(strings[i])) {
                map.put(strings[i], i);
            } else {
                map.put(strings[i], -1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                return entry.getValue();
            }
        }

        return -1;

    }

    /**
     * 牛客网
     *
     * @param str
     * @return
     */
    public int firstNotRepeatingChar2(String str) {
        if (str.length() == 0) {
            return -1;
        }

        char c = 'A';
        if (str.charAt(0) >= 'a') {
            c = 'a';
        }

        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - c]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (counts[str.charAt(i) - c] == 1) {
                return i;
            }
        }

        return -1;
    }

}
