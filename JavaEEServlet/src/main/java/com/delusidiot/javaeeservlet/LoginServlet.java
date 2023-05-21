package com.delusidiot.javaeeservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("user_id");
        String password = req.getParameter("user_password");
        String[] subjects = req.getParameterValues("subject");
        System.out.println(id);
        System.out.println(password);
        for (String s: subjects) {
            System.out.println(s);
        }
    }
}
