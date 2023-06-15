package com.custom.marketplace.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Customer {
  private Long id;
  private String name;
  private String phone;
  private String address;
  private String email;
  private String password;
}
