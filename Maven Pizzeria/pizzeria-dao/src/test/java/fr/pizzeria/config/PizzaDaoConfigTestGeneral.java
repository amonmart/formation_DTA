package fr.pizzeria.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan("fr.pizzeria.dao")
@EnableJpaRepositories("fr.pizzeria.dao.repository")
public class PizzaDaoConfigTestGeneral {
}
