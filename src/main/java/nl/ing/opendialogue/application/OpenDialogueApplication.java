package nl.ing.opendialogue.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(basePackages = "nl.ing.opendialogue")
public class OpenDialogueApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenDialogueApplication.class, args);
    }
}
