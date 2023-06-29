package com.custom.marketplace.data.repositories;

import com.custom.marketplace.data.datasources.CustomerDataSourceLocal;
import com.custom.marketplace.domain.entities.Customer;
import com.custom.marketplace.domain.repositories.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {
  final CustomerDataSourceLocal customerDataSourceLocal;

  public CustomerRepositoryImpl(CustomerDataSourceLocal customerDataSourceLocal) {
    this.customerDataSourceLocal = customerDataSourceLocal;
  }

  @Override
  public Customer createCustomer(Customer customer) {
    return customerDataSourceLocal.createCustomer(customer);
  }

  @Override
  public void deleteCustomer(Long id) {
    customerDataSourceLocal.deleteCustomer(id);
  }

  @Override
  public Customer getCustomer(Long id) {
    return customerDataSourceLocal.getCustomer(id);
  }

}
