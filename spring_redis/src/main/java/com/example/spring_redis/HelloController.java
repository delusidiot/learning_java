package com.example.spring_redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final StringRedisTemplate stringRedisTemplate;

    public HelloController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    private final String fruit = "Fruit";

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/setFruit")
    public String setFruit(@RequestParam String name) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(fruit, name);
        return "ok";
    }

    @GetMapping("/getFruit")
    public String getFruit() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        return ops.get(fruit);
    }
}
