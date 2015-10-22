package com.rentflat.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * LiquidBase configuration
 */
@Configuration
public class LiquibaseConfig {

    @Autowired
    private BasicDataSource dataSource;

    /**
     * Bean for liquibase config
     *
     * @return SpringLiquibase
     */
    @Bean(name = "liquibase")
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:liquibase/db.changelog.xml");
        return liquibase;
    }
}
