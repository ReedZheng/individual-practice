package springlearn;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practicecourt.springlearn.lifecycle.config.AutowiredConfig;
import practicecourt.springlearn.lifecycle.controller.HiController;
import practicecourt.springlearn.lifecycle.service.HiService;

/**
 *
 */
public class IOCAutowiredTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(AutowiredConfig.class);

        HiController hiController = applicationContext.getBean(HiController.class);
        System.out.println(hiController);
        System.out.println(applicationContext.getBean(HiService.class));

        applicationContext.close();
    }
}
