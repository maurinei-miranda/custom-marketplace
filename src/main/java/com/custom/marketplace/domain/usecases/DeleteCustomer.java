package com.custom.marketplace.domain.usecases;

import com.custom.marketplace.domain.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomer {
  final CustomerRepository customerRepository;
  public DeleteCustomer(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }
  public void call(Long id) {
    customerRepository.deleteCustomer(id);
  }
}
