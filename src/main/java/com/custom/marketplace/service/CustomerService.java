package com.custom.marketplace.service;


import com.custom.marketplace.domain.Customer;
import com.custom.marketplace.dto.CustomerDto;
import com.custom.marketplace.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer createCustomer(CustomerDto customerDto){
    Customer customer = Customer.builder()
            .name(customerDto.getName())
            .address(customerDto.getAddress())
            .password(customerDto.getPassword())
            .phone(customerDto.getPhone())
            .build();
    Customer save = customerRepository.save(customer);
    return save;
  }

}
