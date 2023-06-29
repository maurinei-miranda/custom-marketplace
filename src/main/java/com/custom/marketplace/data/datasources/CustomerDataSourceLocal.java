package com.custom.marketplace.data.datasources;

import com.custom.marketplace.domain.entities.Customer;

public interface CustomerDataSourceLocal {
  Customer createCustomer(Customer customer);
  void deleteCustomer(Long id);
  Customer getCustomer(Long id);
}
