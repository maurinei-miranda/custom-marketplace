package com.custom.marketplace.data.datasources.impl;

import com.custom.marketplace.data.datasources.CustomerDataSourceLocal;
import com.custom.marketplace.data.datasources.JpaCustomerRepository;
import com.custom.marketplace.domain.entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class CustomerDataSourceLocalImpl implements CustomerDataSourceLocal {
  final JpaCustomerRepository jpaCustomerRepository;

  public CustomerDataSourceLocalImpl(JpaCustomerRepository jpaCustomerRepository) {
    this.jpaCustomerRepository = jpaCustomerRepository;
  }

  @Override
  public Customer createCustomer(Customer customer) {
    return jpaCustomerRepository.save(customer);
  }

  @Override
  public void deleteCustomer(Long id) {
    jpaCustomerRepository.deleteById(id);

  }

  @Override
  public Customer getCustomer(Long id) {
    Optional<Customer> byId = jpaCustomerRepository.findById(id);
    return byId.get();
  }

  @Override
  public List<Customer> getCustomers() {
    return jpaCustomerRepository.findAll();
  }
}
