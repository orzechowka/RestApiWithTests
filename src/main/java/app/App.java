package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Anna on 2018-10-01.
 */
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories(basePackageClasses = WordRepository.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
