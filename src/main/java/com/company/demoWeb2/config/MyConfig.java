package com.company.demoWeb2.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.company.demoWeb2"},
        excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value={Controller.class})})
@ImportResource(locations = {"classpath:app-config.xml"})
//@EnableAspectJAutoProxy
//@PropertySource({"classpath:mysql/mysql.properties", "classpath:redis/redis.properties"})
public class MyConfig {
}
