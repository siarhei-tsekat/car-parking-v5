package net.tsekot.carparking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String getStatus() {
        return LocalDateTime.now().toString();
    }
}
