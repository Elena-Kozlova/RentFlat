package com.rentflat.configuration.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * Common application configuration
 */
@EnableAspectJAutoProxy
@Configuration
@PropertySource(value = {
        "classpath:application.properties"
})
@ComponentScan({"com.rentflat"})
public class AppConfig {

    /**
     * PropertySourcesPlaceholderConfigurer
     *
     * @return PropertySourcesPlaceholderConfigurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * Initializer for time zone
     */
    @PostConstruct
    public void initTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
    }
}
