package demo.eu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@MapperScan("demo.eu.mapper")
//@ComponentScan(basePackages = {"demo.eu.controller", "demo.eu.service"})
@SpringBootApplication
@RestController
public class UserApplication {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}


