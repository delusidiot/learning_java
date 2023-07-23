package com.example.spring_redis;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 단일 서버에서는 Session 만으로 충분히 로그인을 구현할 수 있다.
 */

@RestController
@RequestMapping("/auth/v2")
public class RedisLoginController {

    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name) {
        session.setAttribute("name", name);
        return "ok";
    }

    @GetMapping("/myName")
    public String myName(HttpSession session) {
        return (String) session.getAttribute("name");
    }
}
