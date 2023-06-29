package com.custom.marketplace.data.mappers;

import com.custom.marketplace.data.models.CustomerModel;
import com.custom.marketplace.data.models.CustomerResponse;
import com.custom.marketplace.domain.entities.Customer;

public interface CustomCustomerMapper {
  Customer modelToDomain(CustomerModel customerModel);
  CustomerResponse domainToResponse(Customer customer);
}
