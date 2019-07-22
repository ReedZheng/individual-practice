package practicecourt.springlearn.lifecycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import practicecourt.springlearn.lifecycle.entity.Car;

/**
 *
 */
@Configuration
@ComponentScan("practicecourt.springlearn")
public class LifeCycleConfig {

    @Bean(initMethod = "init",
          destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
