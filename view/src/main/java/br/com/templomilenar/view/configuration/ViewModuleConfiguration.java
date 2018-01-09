package br.com.templomilenar.view.configuration;

import br.com.templomilenar.card_price.configuration.CardPriceModuleConfiguration;
import br.com.templomilenar.service.configuration.ServiceModuleConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"br.com.templomilenar.view.controller"})
@Import({ServiceModuleConfiguration.class, CardPriceModuleConfiguration.class})
public class ViewModuleConfiguration {

}
