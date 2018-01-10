package br.com.templomilenar.service.configuration;

import br.com.templomilenar.cardprice.configuration.CardPriceModuleConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"br.com.templomilenar.service.services"})
@Import(CardPriceModuleConfiguration.class)
public class ServiceModuleConfiguration {

}
