package br.com.templomilenar.application;

import br.com.templomilenar.configuration.ViewModuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Spring Boot Application class
 *
 * @author igorventurelli
 * @since 1.0.0
 */
@SpringBootApplication
@Import(ViewModuleConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
