package com.custom.marketplace.domain.repositories;

import com.custom.marketplace.domain.entities.Customer;

public interface CustomerRepository {
  public Customer createCustomer(Customer customer);
  public void deleteCustomer(Long id);
  public Customer getCustomer(Long id);
  public Iterable<Customer> getCustomers();

}
