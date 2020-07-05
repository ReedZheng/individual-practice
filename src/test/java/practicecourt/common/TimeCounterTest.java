package practicecourt.common;

import org.junit.Test;
import practicecourt.java8.TimeCounter;

public class TimeCounterTest {

    @Test
    public void needTime() {
    }

    @Test
    public void firstDateInMonth() {
        System.out.println(TimeCounter.firstDateInMonth());
    }

    @Test
    public void lastDateInMonth() {
        System.out.println(TimeCounter.lastDateInMonth());
    }
}