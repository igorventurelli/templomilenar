package br.com.templomilenar.service.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"br.com.templomilenar.service.services"})
public class ServiceModuleConfiguration {

}
