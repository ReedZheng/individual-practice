package practicecourt.springlearn.lifecycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import practicecourt.springlearn.lifecycle.service.HiService;

/**
 *
 */
@Controller
public class HiController {

    @Autowired
    private HiService service;

    @Override
    public String toString() {
        return service.toString();
    }
}
