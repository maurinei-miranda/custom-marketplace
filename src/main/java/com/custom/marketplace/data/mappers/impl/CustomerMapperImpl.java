package com.custom.marketplace.data.mappers.impl;

import com.custom.marketplace.data.mappers.CustomCustomerMapper;
import com.custom.marketplace.data.models.CustomerModel;
import com.custom.marketplace.data.models.CustomerResponse;
import com.custom.marketplace.domain.entities.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapperImpl implements RowMapper<Customer>, CustomCustomerMapper {

  @Override
  public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
    return Customer.builder()
            .id(rs.getLong("id"))
            .name(rs.getString("name"))
            .phone(rs.getString("phone"))
            .email(rs.getString("email"))
            .address(rs.getString("address"))
            .password(rs.getString("password"))
            .build();
  }

  public Customer modelToDomain(CustomerModel customerModel) {
    return Customer.builder()
            .name(customerModel.getName())
            .phone(customerModel.getPhone())
            .email(customerModel.getEmail())
            .address(customerModel.getAddress())
            .password(customerModel.getPassword())
            .build();
  }

  public CustomerResponse domainToResponse(Customer customer) {
    return CustomerResponse.builder()
            .id(customer.getId())
            .name(customer.getName())
            .email(customer.getEmail())
            .address(customer.getAddress())
            .phone(customer.getPhone())
            .build();
  }
}
