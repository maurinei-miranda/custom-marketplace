package com.custom.marketplace.domain.repositories;

import com.custom.marketplace.domain.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {
  public Customer createCustomer(Customer customer);
  public void deleteCustomer(Long id);
  public Customer getCustomer(Long id);
  public List<Customer> getCustomers();

}
