package com.custom.marketplace.domain.repositories;

import com.custom.marketplace.domain.entities.Customer;

public interface CustomerRepository {
  Customer createCustomer(Customer customer);

  void deleteCustomer(Long id);

  Customer getCustomer(Long id);
}
