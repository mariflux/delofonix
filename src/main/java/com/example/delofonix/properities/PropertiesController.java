package com.example.delofonix.properities;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PropertiesController {


    @Value("${uri}")
    String uri;

    @Value("${userName}")
    String userName;


    @Value("${password}")
    String password;

    @Value("${pathToDatabase}")
    String pathToDatabase;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPathToDatabase() {
        return pathToDatabase;
    }

    public void setPathToDatabase(String pathToDatabase) {
        this.pathToDatabase = pathToDatabase;
    }
}

