package com.ntq.springlearn;

import com.ntq.springlearn.configurationproperties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
@EnableConfigurationProperties
public class SpringLearnApplication implements CommandLineRunner {
    @Autowired
    AppProperties appProperties;



    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Global Variable");
        System.out.println("\t Email " + appProperties.getEmail());
        System.out.println("\t Ga Id" + appProperties.getGoogleAnalyticsId());
        System.out.println("\t Authors" + appProperties.getAuthors());
        System.out.println(" \t Example Map " + appProperties.getExampleMap());
    }
}
