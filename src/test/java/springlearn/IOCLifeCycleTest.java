package springlearn;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practicecourt.springlearn.lifecycle.config.LifeCycleConfig;
import practicecourt.springlearn.lifecycle.entity.Cat;

/**
 *
 */
public class IOCLifeCycleTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("容器创建完成...");
        Cat car = (Cat)applicationContext.getBean("cat");
        Cat car2 = (Cat)applicationContext.getBean("cat");
        System.out.println(car == car2);
        applicationContext.close();
    }
}
