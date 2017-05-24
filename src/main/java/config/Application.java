package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.rit.enrollment.repository")
@ComponentScan
@EntityScan(basePackages = "com.rit.enrollment.repository")
public class Application {
 
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class);
    }
    
}    
