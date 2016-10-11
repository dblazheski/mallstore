package com.mallstore.ui.assembler;

import com.mallstore.domain.model.customer.Customer;
import com.mallstore.ui.dto.CustomerDto;


public interface CustomerMapper {

    Customer mapFromDTO(CustomerDto customerDto);
    CustomerDto mapToDTO(Customer customer);
}
