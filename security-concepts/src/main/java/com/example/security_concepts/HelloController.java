package com.example.security_concepts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping({ "/", "/home" })
    public String home() {
        return "Home Works";
    }

    @GetMapping("/about")
    public String about() {
        return "About Works";
    }

    @GetMapping("/contact")
    public String contact() {
        return "Contact Works";
    }
}