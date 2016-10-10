package com.mallstore.ui.validator;

import com.mallstore.ui.dto.CustomerDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by DeKi on 8/23/2016.
 */
@Component
public class CustomerValidator implements Validator {

  private final static String TRANSLATION_KEY = "notEmpty.customer.";
  private final String PROPERTY_PATH = "required/required.properties";

  public boolean supports(Class<?> clazz) {
    return false;
  }

  public void validate(Object target, Errors errors) {

    CustomerDto customer = (CustomerDto) target;
    Properties properties = loadProperties(PROPERTY_PATH);
    String required = properties.getProperty("customer");
    if (required != null) {
      String[] requiredList = required.split(",");
      for (String requiredField : requiredList) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, requiredField, TRANSLATION_KEY + requiredField.toLowerCase());
      }
    }
  }

  private Properties loadProperties(String propertyPath) {
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyPath);
    if (inputStream == null) {
      throw new RuntimeException("Property path not found: " + propertyPath);
    }
    Properties properties = new Properties();
    try {
      properties.load(inputStream);
    } catch (IOException e) {
      throw new RuntimeException("Error while reading propertyPath: " + propertyPath, e);
    }
    return properties;
  }
}
