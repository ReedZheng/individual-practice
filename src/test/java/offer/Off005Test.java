package offer;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import practicecourt.offer.Off005;

@Slf4j
public class Off005Test {

    @Test
    public void replaceSpace() {
        String s = new Off005().replaceSpace(" A  B asdfasdfe asdf23wfrasdfa sdfsdfa   ");
        log.info("替换后的字符串为：{}", s);
    }

    @Test
    public void replaceSpace1() {
        // TODO aop 计算耗时
        LocalDateTime startTime = LocalDateTime.now();
        String s = new Off005().replaceSpace1(new StringBuffer(" A  B asdfasdfe asdf23wfrasdfa sdfsdfa   "));
        LocalDateTime endTime = LocalDateTime.now();
        // Duration duration = Duration.between(startTime, endTime);
        // duration.getNano()
        log.info("起始：{}，结束：{}", startTime, endTime);
        log.info("替换后的字符串为：{}", s);
    }
}