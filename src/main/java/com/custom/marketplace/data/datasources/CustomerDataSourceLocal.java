package com.custom.marketplace.data.datasources;

import com.custom.marketplace.domain.entities.Customer;

public interface CustomerDataSourceLocal {
  public Customer createCustomer(Customer customer);
  public void deleteCustomer(Long id);
  public Customer getCustomer(Long id);
  public Iterable<Customer> getCustomers();
}
