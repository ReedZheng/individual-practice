package practicecourt.leet;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeNumberTest {

    @Test
    public void isPalindrome() {
        System.out.println(new PalindromeNumber().isPalindrome3(5221225));
        System.out.println(new PalindromeNumber().isPalindrome3(52211225));
        System.out.println(new PalindromeNumber().isPalindrome3(10));
        System.out.println(new PalindromeNumber().isPalindrome3(-10));
        System.out.println(new PalindromeNumber().isPalindrome3(0));
        System.out.println(new PalindromeNumber().isPalindrome3(Integer.MAX_VALUE));
    }
}