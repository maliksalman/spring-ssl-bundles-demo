package com.example.sslbundlesdemo.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkController {

    private final HeroService service;

    public WorkController(HeroService service) {
        this.service = service;
    }

    @GetMapping("/work")
    public List<Hero> doWork() {
        return service.list();
    }
}
