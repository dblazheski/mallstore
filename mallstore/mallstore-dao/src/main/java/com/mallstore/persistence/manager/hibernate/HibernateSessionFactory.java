package com.mallstore.persistence.manager.hibernate;

import com.mallstore.domain.model.customer.Customer;
import com.mallstore.domain.model.order.Order;
import com.mallstore.domain.model.order.OrderItem;
import com.mallstore.domain.model.product.Product;
import com.mallstore.domain.model.product.category.Category;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by DeKi on 1/16/2016.
 */
@Component
public class HibernateSessionFactory {

  @Bean
  private SessionFactory createInstance() {
    Configuration configuration = new Configuration();
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
        configuration.getProperties()).build();
    return configuration.addAnnotatedClass(Category.class)
        .addAnnotatedClass(Customer.class)
        .addAnnotatedClass(Order.class)
        .addAnnotatedClass(Product.class)
        .addAnnotatedClass(OrderItem.class)
            .addAnnotatedClass(Category.class)
        .buildSessionFactory(serviceRegistry);
  }
}
