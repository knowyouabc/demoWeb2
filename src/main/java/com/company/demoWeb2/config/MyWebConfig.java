package com.company.demoWeb2.config;

import com.company.demoWeb2.util.OrikaBeanMapper;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.company.demoWeb2.controller"})
@ImportResource(locations = {"classpath:spring-config.xml"})
@Import(ExecutorConfiguration.class)
//@ComponentScan(basePackages = {"com.company.demoWeb2"},
//        excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value={Controller.class})})
//@EnableAspectJAutoProxy
//@PropertySource({"classpath:mysql/mysql.properties", "classpath:redis/redis.properties"})
public class MyWebConfig {
    @Bean
    public OrikaBeanMapper orikaMapper() {
        return new OrikaBeanMapper();
    }
}
