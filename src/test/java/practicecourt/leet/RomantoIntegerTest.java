package practicecourt.leet;

import org.junit.Test;

public class RomantoIntegerTest {

    @Test
    public void romanToInt() {
        String[] strs = {"MCMXCIV", "LVIII", "IX", "IV", "III", "", "M", "ASDF", "CCMXV"};

        for (String str : strs) {
            int i = new RomantoInteger().romanToInt(str);
            System.out.println(i);
        }
    }
}