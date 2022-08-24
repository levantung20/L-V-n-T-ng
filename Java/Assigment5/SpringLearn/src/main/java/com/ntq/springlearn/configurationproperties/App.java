//package com.ntq.springlearn.configurationproperties;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//@EnableConfigurationProperties
//@Component
//public class App  implements CommandLineRunner {
//    @Autowired
//    AppProperties appProperties;
//    @Override
//    public void run(String... args) throws Exception {
//            System.out.println("Global Variable");
//            System.out.println("\t Email: " + appProperties.getEmail());
//            System.out.println("\t Ga ID : " + appProperties.getGoogleAnalyticsId());
//            System.out.println("\t Authors " + appProperties.getAuthors());
//            System.out.println("\t Example Map" + appProperties.getExampleMap());
//        }
//
//    public static void main(String[] args) {
//
//    }
//    }
