package com.custom.marketplace.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CustomerDto {
  private String name;
  private String phone;
  private String address;
  private String email;
  private String password;
}
