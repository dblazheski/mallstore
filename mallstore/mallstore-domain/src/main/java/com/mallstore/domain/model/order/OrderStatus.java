package com.mallstore.domain.model.order;

import java.io.Serializable;

/**
 * Created by DeKi on 8/25/2016.
 */
public enum OrderStatus implements Serializable {
  PENDING,
  COMPLETED,
  CANCELED;
}
