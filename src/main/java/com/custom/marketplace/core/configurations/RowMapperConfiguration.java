package com.custom.marketplace.core.configurations;


import com.custom.marketplace.data.mappers.impl.CustomerMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RowMapperConfiguration {

  @Bean
  public CustomerMapper customerRowMapper(){
    return new CustomerMapper();
  }
}
