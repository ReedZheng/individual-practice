package practicecourt.java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TimeCounter {
    /**
     * toMinutes() 分钟，计算两个时间相差多少分钟
     * @param startTime
     * @param endTime
     * @return
     */
    public static long needTime(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        return duration.toMillis();
    }

    /**
     * 本月的第一天
     * @return
     */
    public static LocalDate firstDateInMonth() {
        LocalDate today = LocalDate.now();
        return LocalDate.of(today.getYear(), today.getMonth(), 1);
    }

    /**
     * 本月的最后一天
     * @return
     */
    public static LocalDate lastDateInMonth() {
        LocalDate today = LocalDate.now();
        return today.with(TemporalAdjusters.lastDayOfMonth());
    }
}
