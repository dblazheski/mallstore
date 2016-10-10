package com.mallstore.ui.assembler;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.customer.Credential;
import com.mallstore.domain.model.customer.Customer;
import com.mallstore.domain.model.customer.CustomerBuilder;
import com.mallstore.domain.model.customer.Name;
import com.mallstore.domain.model.customer.address.Address;
import com.mallstore.domain.model.customer.address.Street;
import com.mallstore.ui.dto.CustomerDto;

import java.util.UUID;

/**
 * Created by DeKi on 8/23/2016.
 */
public class CustomerAssembler {

  public Customer fromDTO(CustomerDto customerDto) {
    EntityId id = new EntityId(UUID.randomUUID().toString());
    return new CustomerBuilder(id, buildNameFromDto(customerDto), buildCredentialFromDto(customerDto))
        .setAddress(buildAddressFromDto(customerDto))
        .build();
  }

  private Credential buildCredentialFromDto(CustomerDto customerDto) {
    return new Credential(customerDto.getUsername(), customerDto.getPassword());
  }

  private Address buildAddressFromDto(CustomerDto customerDto) {
    return new Address(
        buildStreetFromDto(customerDto),
        customerDto.getCity(),
        customerDto.getCountry());
  }

  private Street buildStreetFromDto(CustomerDto customerDto) {
    return new Street(
        customerDto.getStreet(),
        customerDto.getNumber(),
        customerDto.getZip());
  }

  private Name buildNameFromDto(CustomerDto customerDto) {
   return new Name(customerDto.getUsername(), customerDto.getPassword());
  }

  public CustomerDto toDTO(Customer customer) {
    if(customer == null) {
      return null;
    }
    CustomerDto customerDto = new CustomerDto();
    setNameInformationFromCustomer(customerDto, customer.getName());
    setAddressInformationFromCustomer(customerDto, customer.getAddress());
    setUsernameFromCustomer(customerDto, customer.getCredential());
    return customerDto;
  }

  private void setNameInformationFromCustomer(CustomerDto customerDto, Name name) {
    if(name == null) {
      return;
    }

    customerDto.setFirstName(name.getFirstName());
    customerDto.setLastName(name.getLastName());
  }

  private void setAddressInformationFromCustomer(CustomerDto customerDto, Address address) {
    if(address == null) {
      return;
    }

    setStreetInformationFromCustomer(customerDto, address.getStreet());
    customerDto.setCity(address.getCity());
    customerDto.setCountry(address.getCountry());
  }

  private void setStreetInformationFromCustomer(CustomerDto customerDto, Street street) {
    if(street == null) {
      return;
    }

    customerDto.setStreet(street.getStreet());
    customerDto.setNumber(street.getNumber());
    customerDto.setZip(street.getZip());
  }

  private void setUsernameFromCustomer(CustomerDto customerDto, Credential credential) {
    if(credential == null) {
      return;
    }
    customerDto.setUsername(credential.getUsername());
  }
}
