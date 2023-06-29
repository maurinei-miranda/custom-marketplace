package com.custom.marketplace.data.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CustomerResponse {
  private Long id;
  private String name;
  private String phone;
  private String address;
  private String email;
}
