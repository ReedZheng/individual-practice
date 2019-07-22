package practicecourt.springlearn.lifecycle.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@ComponentScan({"practicecourt.springlearn.lifecycle.controller", "practicecourt.springlearn.lifecycle.service"})
public class AutowiredConfig {

}
