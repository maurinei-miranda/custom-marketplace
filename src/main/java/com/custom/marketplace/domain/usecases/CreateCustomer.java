package com.custom.marketplace.domain.usecases;

import com.custom.marketplace.domain.entities.Customer;
import com.custom.marketplace.domain.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomer {
  private final CustomerRepository customerRepository;

  public CreateCustomer(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer call(Customer customer) {
    return customerRepository.createCustomer(customer);
  }


}
