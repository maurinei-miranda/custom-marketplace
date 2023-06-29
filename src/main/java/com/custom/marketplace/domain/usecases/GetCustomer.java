package com.custom.marketplace.domain.usecases;

import com.custom.marketplace.domain.entities.Customer;
import com.custom.marketplace.domain.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class GetCustomer {
  final CustomerRepository customerRepository;

  public GetCustomer(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer call(Long id) {
    return customerRepository.getCustomer(id);
  }
}
