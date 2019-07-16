package springlearn;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import practicecourt.springlearn.lifecycle.config.LifeCycleConfig;
import practicecourt.springlearn.lifecycle.entity.Car;

/**
 *
 */
public class IOCLifeCycleTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
            LifeCycleConfig.class);
        System.out.println("容器创建完成...");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println("car: " + car);
        applicationContext.close();
    }
}
