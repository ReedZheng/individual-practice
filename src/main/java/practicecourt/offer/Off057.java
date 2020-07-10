package practicecourt.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时， 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。 google -> ggg#ll
 */
public class Off057 {

    LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

    // Insert one char from stringstream
    public void insert(char ch) {
        String s = ch + "";
        if (map.containsKey(s)) {
            map.put(s, -1);
        } else {
            map.put(s, 1);
        }
    }

    // return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey().toCharArray()[0];
            }
        }

        return '#';
    }
}
