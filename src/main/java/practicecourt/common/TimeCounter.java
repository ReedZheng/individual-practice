package practicecourt.common;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeCounter {

    public static long needTime(LocalDateTime startTime, LocalDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        // toMinutes() 分钟
        return duration.toMillis();
    }
}
