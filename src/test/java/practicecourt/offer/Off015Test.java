package practicecourt.offer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StopWatch;

@Slf4j
public class Off015Test {

    @Test
    public void power() {
        StopWatch stWatch = new StopWatch();
        stWatch.start();
        double power = new Off015().power(78, 100);
        stWatch.stop();
        log.info("耗时：{} ms", stWatch.getTotalTimeMillis());
        System.out.println(power);
    }

    @Test
    public void otherMethod() {
        StopWatch stWatch = new StopWatch();
        stWatch.start();
        double v = new Off015().otherMethod(78, 100);
        stWatch.stop();
        log.info("耗时：{} ms", stWatch.getTotalTimeMillis());
        System.out.println(v);
    }
}
