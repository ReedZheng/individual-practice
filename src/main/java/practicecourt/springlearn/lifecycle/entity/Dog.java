package practicecourt.springlearn.lifecycle.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class Dog {

    public Dog() {
        System.out.println("dog..construct..");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("dog..postConstruct..");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("dog..predestroy..");
    }
}
