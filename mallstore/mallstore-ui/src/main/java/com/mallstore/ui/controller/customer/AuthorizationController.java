package com.mallstore.ui.controller.customer;

import com.mallstore.domain.model.customer.Customer;
import com.mallstore.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(path = "/login")
@Controller
public class AuthorizationController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST)
    public String login(@RequestParam String user, @RequestParam String password) {
        Customer customer = customerService.getCustomerByLogin(user);
        if(customer == null) {
            return "login";
        }
        if(user.equals(customer.getCredential().getUsername()) && password.equals(customer.getCredential().getPassword())) {
            return "redirect:/profile";
        }
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginModel() {
        return "login";
    }
}
