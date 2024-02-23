package com.example.sslbundlesdemo.client;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/heroes")
public interface HeroService {

    @GetExchange
    List<Hero> list();

}
