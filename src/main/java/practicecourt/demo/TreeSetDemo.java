package practicecourt.demo;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: zhengfenghong
 * @date: 2020/9/3 20:54
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()==o2.length()) {
                    return 1;
                }
                return Integer.compare(o1.length(), o2.length());
            }
        });
        set.add("aa");
        set.add("bb");
        set.add("cc");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
