package com.company.demoWeb2.servlet;

import com.company.demoWeb2.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/myServlet2")
public class MyServlet2 extends javax.servlet.http.HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("doPost");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.getWriter().write("doGet");

        response.setStatus(302);//setHeader方式重定向必须加302
        response.setHeader("location", "success.jsp");
//        response.sendRedirect("http://localhost:8080/success.jsp");


        HttpSession hs= request.getSession();
        Person person = (Person)hs.getAttribute("person");
    }
}
