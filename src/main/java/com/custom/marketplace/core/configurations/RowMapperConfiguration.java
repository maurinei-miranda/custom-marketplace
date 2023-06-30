package com.custom.marketplace.core.configurations;


import com.custom.marketplace.data.mappers.impl.CustomerMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RowMapperConfiguration {

  @Bean
  public CustomerMapperImpl customerRowMapper(){
    return new CustomerMapperImpl();
  }
}
