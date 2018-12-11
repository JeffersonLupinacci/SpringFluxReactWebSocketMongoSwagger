package com.jeffersonlupinacci.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Application
 * @author jeffersonlupinacci
 */
@SpringBootApplication
@ComponentScan
public class ReactAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReactAppApplication.class, args);
  }


}
