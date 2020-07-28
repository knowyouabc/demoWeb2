package com.company.demoWeb2.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

//public class MyWebInit implements WebApplicationInitializer {

//    @Override
//    public void onStartup(ServletContext servletContext) {
//        AnnotationConfigWebApplicationContext dispatcherContext =
//                new AnnotationConfigWebApplicationContext();
//        dispatcherContext.register(MyConfig.class);
//
//        DispatcherServlet dispatcher = new DispatcherServlet(dispatcherContext);
//        ServletRegistration.Dynamic sr = servletContext.addServlet("dispatcher", dispatcher);
//        sr.setLoadOnStartup(1);
//        sr.addMapping("/");
//    }
//}
