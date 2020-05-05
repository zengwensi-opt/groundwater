package com.groundwater.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wensi
 */
@SpringBootApplication
public class SupportApplication {

    public static void main(String[] args) {
        System.out.println("项目启动了");
        SpringApplication.run(SupportApplication.class, args);
    }

}
