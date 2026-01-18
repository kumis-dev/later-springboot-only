package ru.practicum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping
    protected String getOk() {
        return "OK!";
    }

    @GetMapping("/test")
    protected String getTest() {
        return "OK from controller!";
    }
}
