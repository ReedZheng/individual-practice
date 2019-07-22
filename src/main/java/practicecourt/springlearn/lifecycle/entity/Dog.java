package practicecourt.springlearn.lifecycle.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
