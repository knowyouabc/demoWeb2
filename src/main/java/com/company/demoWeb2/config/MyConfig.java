package com.company.demoWeb2.config;

import org.springframework.context.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = {"com.company.demoWeb2"})
@EnableAspectJAutoProxy
@ImportResource(locations = {"classpath:mysql/mysql-config.xml","classpath:redis/redis-config.xml"})
//@PropertySource({"classpath:mysql/mysql.properties", "classpath:redis/redis.properties"})
public class MyConfig {
}
