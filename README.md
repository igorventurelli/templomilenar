# Templo Milenar ERP

ERP do Templo Milenar.  

[![Build Status](https://travis-ci.org/igorventurelli/templomilenar.svg?branch=master)](https://travis-ci.org/igorventurelli/templomilenar) [![Quality Gate](https://sonarcloud.io/api/badges/gate?key=br.com.templomilenar:templomilenar)](https://sonarcloud.io/dashboard/index/br.com.templomilenar:templomilenar)

## Módulos

O ERP é um projeto [Spring Boot](https://projects.spring.io/spring-boot/) dividido em módulos [Maven](https://maven.apache.org/):

- `application`: módulo responsável pela aplicação em si.  
Nesse módulo está a classe anotada com  a anotação `@SpringBootApplication`.

- `view`: módulo responsável por conter os HTMLs, CSSs, JSs e Controllers.

- `service`: módulo responsável por conter os serviços da aplicação

- `card-price`: módulo responsável por fornecer os preços das cartas baseado na API de [Yugioh Prices](yugiohprices.com).

----------

## Frameworks
São utilizados alguns frameworks na aplicação:

- [Spring Boot](https://projects.spring.io/spring-boot)
- [Maven](https://maven.apache.org/)
- [Thymeleaf](http://www.thymeleaf.org/)
- [Jackson](https://github.com/FasterXML/jackson)
- [Lombok](https://projectlombok.org/)

## ALM
O ALM da aplicação é constituído por algumas ferramentas:

**SCM**:
- [Git (GitHub)](https://git-scm.com/)

**Integração Contínua**:
- [Travis CI](https://travis-ci.org/)

**Qualidade de Código Fonte**:
- [SonarQube (SonarCloud)](https://sonarcloud.io/)

**Deploy**:
- [Heroku](https://www.heroku.com/)

