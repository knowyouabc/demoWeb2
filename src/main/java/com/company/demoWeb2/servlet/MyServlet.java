package com.company.demoWeb2.servlet;

import com.company.demoWeb2.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyServlet extends javax.servlet.http.HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("doPost");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.getWriter().write("doGet");
        HttpSession hs= request.getSession();
        Person person = (Person)hs.getAttribute("person");

        if (person == null) {
            person = new Person();
            person.setName("HttpSession");
            hs.setAttribute("person", person);

            Cookie c = new Cookie("CookieKey", "CookieValue");
            response.addCookie(c);
        }

        Cookie[] cs = request.getCookies();


        request.getRequestDispatcher("/myServlet2").forward(request, response);
    }
}
