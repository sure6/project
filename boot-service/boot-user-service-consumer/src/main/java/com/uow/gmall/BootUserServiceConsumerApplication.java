package com.uow.gmall;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@EnableDubbo
@ComponentScan(basePackages = {"com.uow.gmall.mapper","com.uow.gmall.service","com.uow.gmall.controller" })
//@MapperScan(basePackages= {"mapper"})
@SpringBootApplication
public class BootUserServiceConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(BootUserServiceConsumerApplication.class, args);
    }

}
