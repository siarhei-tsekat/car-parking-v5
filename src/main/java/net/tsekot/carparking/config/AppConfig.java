package net.tsekot.carparking.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("parking");
    }
}
