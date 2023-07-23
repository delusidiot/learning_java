package com.example.spring_redis;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 단일 서버에서는 Session 만으로 충분히 로그인을 구현할 수 있다.
 */

@RestController
@RequestMapping("/auth/v1")
public class LoginController {

    private final Map<String, String> inMemorySession;

    public LoginController() {
        inMemorySession = new HashMap<>();
    }

    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name) {
        inMemorySession.put(session.getId(), name);
        return "ok";
    }

    @GetMapping("/myName")
    public String myName(HttpSession httpSession) {
        return inMemorySession.get(httpSession.getId());
    }
}
