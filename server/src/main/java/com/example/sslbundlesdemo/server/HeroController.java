package com.example.sslbundlesdemo.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    @GetMapping
    public List<Hero> list() {
        return List.of(
                new Hero(1, "superman", 35),
                new Hero(2, "batman", 45),
                new Hero(3, "flash", 25)
        );
    }

}
