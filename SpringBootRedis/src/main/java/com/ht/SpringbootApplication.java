package com.ht;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @SpringBootApplication该注解指定项目是springboot项目，
 * 由此类当作程序路口自动装配web依赖环境
 * */
@SpringBootApplication
//@MapperScan("com.ht.mapper")
@ServletComponentScan
public class SpringbootApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootApplication.class);
    }
}
