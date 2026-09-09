package com.enviro.assessment.junior.tumaholenkhatho;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Tells Spring this class handles incoming HTTP requests and returns raw data
// (JSON/plain text)  rather than an HTML view.
@RestController 
public class HelloController {

    // Maps HTTP GET requests at /hello to this method.
    // Used here to prove the server + routing works end-to-end.
    @GetMapping("/hello")
    public String sayHello() {
        return "Enviro365 backend is alive";
    }
    
}
