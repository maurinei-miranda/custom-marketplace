package com.custom.marketplace.data.controllers;

import com.custom.marketplace.data.mappers.CustomCustomerMapper;
import com.custom.marketplace.data.models.CustomerModel;
import com.custom.marketplace.data.models.CustomerResponse;
import com.custom.marketplace.domain.entities.Customer;
import com.custom.marketplace.domain.usecases.CreateCustomer;
import com.custom.marketplace.domain.usecases.DeleteCustomer;
import com.custom.marketplace.domain.usecases.GetCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  final CreateCustomer createCustomer;
  final DeleteCustomer deleteCustomer;
  final GetCustomer getCustomer;
  final CustomCustomerMapper customCustomerMapper;

  public CustomerController(CreateCustomer createCustomer, DeleteCustomer deleteCustomer, GetCustomer getCustomer, CustomCustomerMapper customCustomerMapper) {
    this.createCustomer = createCustomer;
    this.deleteCustomer = deleteCustomer;
    this.getCustomer = getCustomer;
    this.customCustomerMapper = customCustomerMapper;
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id) {
    Customer domain = getCustomer.call(id);
    CustomerResponse customerResponse = customCustomerMapper.domainToResponse(domain);
    return new ResponseEntity<>(customerResponse, HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerModel customerModel) {
    Customer customerDomain = customCustomerMapper.modelToDomain(customerModel);
    Customer customer = createCustomer.call(customerDomain);
    CustomerResponse customerResponse = customCustomerMapper.domainToResponse(customer);
    return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
    deleteCustomer.call(id);
    return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
  }
}
