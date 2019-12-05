package com.example.delofonix.database.configuration;

import com.example.delofonix.properities.PropertiesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    PropertiesController propertiesController;

    @Primary
    @Bean(name = "usersDataSource")
    //@ConfigurationProperties(prefix = "userDataSource")
    public DataSource getUsersDataSource() throws Exception {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        // dataSourceBuilder.driverClassName("org.h2.Driver");
        //dataSourceBuilder.url("jdbc:h2:mem:test");
        //dataSourceBuilder.url("jdbc:h2:file:"+propertiesController.getPathToDatabase());
        dataSourceBuilder.url("jdbc:h2:./test");
        return dataSourceBuilder.build();
        // return DataSourceBuilder.create().build();
    }

    @Bean(name = "usersJdbcTemplate")
    public JdbcTemplate usersJdbcTemplate() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getUsersDataSource());
        return jdbcTemplate;
    }
}
