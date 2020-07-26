package com.company.demoWeb2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.company.demoWeb2"})
@EnableAspectJAutoProxy
@ImportResource(locations = {"classpath:mysql/mysql-config.xml","classpath:redis/redis-config.xml"})
public class MyConfig {
}
