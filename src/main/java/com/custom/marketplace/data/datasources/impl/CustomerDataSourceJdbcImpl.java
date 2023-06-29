package com.custom.marketplace.data.datasources.impl;

import com.custom.marketplace.data.datasources.CustomerDataSourceLocal;
import com.custom.marketplace.domain.entities.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;


@Component
@Profile("h2")
public class CustomerDataSourceJdbcImpl implements CustomerDataSourceLocal {

  final KeyHolder keyHolder = new GeneratedKeyHolder();
  final JdbcTemplate jdbcTemplate;
  final RowMapper<Customer> customerRowMapper;

  public CustomerDataSourceJdbcImpl(JdbcTemplate jdbcTemplate, RowMapper<Customer> customerRowMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.customerRowMapper = customerRowMapper;
  }

  @Override
  public Customer createCustomer(Customer customer) {
    String insertQuery = "INSERT INTO customer (address, email, name, password, phone) VALUES (?, ?, ?, ?, ?)";
    jdbcTemplate.update(con -> {
      PreparedStatement pst = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
      pst.setString(3, customer.getName());
      pst.setString(2, customer.getEmail());
      pst.setString(1, customer.getAddress());
      pst.setString(4, customer.getPassword());
      pst.setString(5, customer.getPhone());
      return pst;
    }, keyHolder);
    Long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
    customer.setId(id);

    return customer;
  }

  @Override
  public void deleteCustomer(Long id) {
    String deleteQuery = "DELETE FROM customer WHERE id = ?";
    jdbcTemplate.update(deleteQuery, id);

  }

  @Override
  public Customer getCustomer(Long id) {
    String selectQuery = "SELECT * FROM customer WHERE id = ?";
    return jdbcTemplate.queryForObject(selectQuery, customerRowMapper, id);
  }

}
