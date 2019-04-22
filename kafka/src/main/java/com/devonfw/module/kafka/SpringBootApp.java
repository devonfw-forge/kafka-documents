package com.devonfw.module.kafka;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

import com.devonfw.module.kafka.config.KafkaProducerProperties;

@ComponentScan(basePackages = { "com" })
@ServletComponentScan(basePackages = { "com" })
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class, SecurityAutoConfiguration.class })
public class SpringBootApp {
  /**
   * Entry point for spring-boot based app
   *
   * @param args - arguments
   */
  public static void main(String[] args) {

    SpringApplication.run(SpringBootApp.class, args);
  }

}