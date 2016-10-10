package com.mallstore.domain.service;

/**
 * Created by DeKi on 8/7/2016.
 */
public class UserExistException extends RuntimeException {

  public UserExistException(String message) {
    super(message);
  }

  public UserExistException(String message, Throwable cause) {
    super(message, cause);
  }
}
