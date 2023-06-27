package com.custom.marketplace.data.datasources.impl;

import com.custom.marketplace.data.datasources.CustomerDataSourceLocal;
import com.custom.marketplace.domain.entities.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Profile("h2")
public class CustomerDataSourceJdbcImpl implements CustomerDataSourceLocal {

  final JdbcTemplate jdbcTemplate;
  final DataSource dataSource;

  public CustomerDataSourceJdbcImpl(JdbcTemplate jdbcTemplate, DataSource dataSource) {
    this.jdbcTemplate = jdbcTemplate;
    this.dataSource = dataSource;
  }

  @Override
  public Customer createCustomer(Customer customer) {
    String insertQuery = "INSERT INTO customer (address, email, name, password, phone) values (?, ?, ?, ?, ?)";
     return jdbcTemplate.queryForObject(insertQuery,
             new Object[]{customer.getAddress(), customer.getEmail(), customer.getName(), customer.getPassword(), customer.getPhone()} ,
             Customer.class);
  }

  @Override
  public void deleteCustomer(Long id) {
    String deleteQuery = "DELETE FROM customer WHERE id = ?";
//    jdbcTemplate.execute(deleteQuery, id);

  }

  @Override
  public Customer getCustomer(Long id) {
    String selectQuery = "SELECT * FROM customer WHERE id = ?";
    return jdbcTemplate.queryForObject(selectQuery, new Object[]{id}, Customer.class);
  }

  @Override
  public Iterable<Customer> getCustomers() {
    return null;
  }
}
