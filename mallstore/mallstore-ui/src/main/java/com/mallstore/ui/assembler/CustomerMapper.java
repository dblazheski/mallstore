package com.mallstore.ui.assembler;

import com.mallstore.domain.model.customer.Customer;
import com.mallstore.ui.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper
public interface CustomerMapper {

    @Mappings({
            @Mapping(target = "")
    })
    Customer mapFromDTO(CustomerDto customerDto);
    CustomerDto mapToDTO(Customer customer);
}
