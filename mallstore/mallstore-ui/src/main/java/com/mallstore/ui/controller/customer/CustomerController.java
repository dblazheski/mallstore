package com.mallstore.ui.controller.customer;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.customer.Customer;
import com.mallstore.domain.model.order.Order;
import com.mallstore.domain.service.CustomerService;
import com.mallstore.domain.service.OrderService;
import com.mallstore.ui.assembler.CustomerAssembler;
import com.mallstore.ui.dto.CustomerDto;
import com.mallstore.ui.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by DeKi on 8/22/2016.
 */
@Controller
public class CustomerController {

  private final static String PATH = "customer/";

  @Autowired
  private CustomerService customerService;
  @Autowired private OrderService orderService;

  @Autowired
  private CustomerValidator customerValidator;

  @RequestMapping(value = PATH + "register", method = RequestMethod.GET)
  public String renderForm(CustomerDto customerDto) {
    return PATH + "register";
  }

  @RequestMapping(value = PATH + "register", method = RequestMethod.POST)
  public String registerNewCustomer(@Valid @ModelAttribute CustomerDto customer, BindingResult bindingResult) {

    customerValidator.validate(customer, bindingResult);

    if(bindingResult.hasErrors()) {
      return PATH + "register";
    }

    Customer newCustomer = new CustomerAssembler().fromDTO(customer);
    try {
      customerService.registerNewCustomer(newCustomer);
    } catch (Exception e) {
      bindingResult.reject(e.getMessage(), e.getMessage());
      return PATH + "register";
    }
    return PATH + "success";
  }

  @RequestMapping(value = PATH + "{id}", method = RequestMethod.GET)
  public String getCustomerById(Model model, @PathVariable String id) {
    Customer customer = customerService.getCustomerById(new EntityId(id));
    for(EntityId orderId : customer.getOrderIds()) {
      Order order = orderService.getOrderById(orderId);
      order.getId();
     }
    CustomerDto customerDto = new CustomerAssembler().toDTO(customer);
    model.addAttribute("customer", customerDto);
    return PATH + "info";
  }
}
