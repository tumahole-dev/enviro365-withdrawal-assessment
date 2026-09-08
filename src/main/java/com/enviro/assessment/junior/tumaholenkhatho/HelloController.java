package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Enviro365 backend is alive";
    }
    
}
