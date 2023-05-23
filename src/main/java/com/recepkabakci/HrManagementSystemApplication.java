package com.recepkabakci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HrManagementSystemApplication {

    public static void main(String[] args) {
              SpringApplication.run(HrManagementSystemApplication.class, args);
    }

}
