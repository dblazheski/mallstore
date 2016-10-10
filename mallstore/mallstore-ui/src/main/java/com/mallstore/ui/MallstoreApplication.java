package com.mallstore.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by DeKi on 8/24/2016.
 */
@ComponentScan("com.mallstore")
@SpringBootApplication
public class MallstoreApplication {

  public static void main(String args[]) {
    SpringApplication.run(MallstoreApplication.class);
  }
}
