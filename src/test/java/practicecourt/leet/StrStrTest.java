package practicecourt.leet;

import junit.framework.TestCase;

public class StrStrTest extends TestCase {

    public void testStrStr() {
        StrStr strStr = new StrStr();
        int i = strStr.strStr("mississippi", "issip");
        System.out.println(i);
    }
}