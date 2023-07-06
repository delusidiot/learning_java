package com.example.springtutorial;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

@SpringBootApplication
public class SpringTutorialApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringTutorialApplication.class, args);
        GenericApplicationContext applicationContext = new GenericApplicationContext();// spring container
        applicationContext.registerBean(HelloController.class); // bean 등록 어떤 클래스로 빈을 만들것인가.
        applicationContext.refresh(); // application context가 bean을 생성한다.

        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        WebServer webServer = factory.getWebServer(servletContext -> {
            servletContext.addServlet("frontcontroller", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    //보안, 다국어 처리 등 앞단의 공통적인 작업
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {// Mapping
                        String name = req.getParameter("name");

                        HelloController helloController = applicationContext.getBean(HelloController.class);
                        String ret = helloController.hello(name); // Binding

                        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(ret);
                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }

                }
            }).addMapping("/*"); // 모든 요청을 처리할 수 있도록 Mapping 해준다.
        });
        webServer.start();
    }
}

class HelloController {
    public String hello(String name) {
        return "Hello " + name;
    }
}