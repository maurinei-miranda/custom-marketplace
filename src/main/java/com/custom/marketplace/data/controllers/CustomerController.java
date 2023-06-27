package com.custom.marketplace.data.controllers;

import com.custom.marketplace.data.models.CustomerModel;
import com.custom.marketplace.domain.entities.Customer;
import com.custom.marketplace.domain.usecases.CreateCustomer;
import com.custom.marketplace.domain.usecases.DeleteCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  final CreateCustomer createCustomer;
  final DeleteCustomer deleteCustomer;

  public CustomerController(CreateCustomer createCustomer, DeleteCustomer deleteCustomer) {
    this.createCustomer = createCustomer;
    this.deleteCustomer = deleteCustomer;
  }

  @GetMapping("/get")
  public ResponseEntity<String> testEndpoint() {
    return new ResponseEntity<>("ASD", HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customerModel) {
    Customer custom = new Customer();
    Customer customer = createCustomer.call(custom);
    System.out.println(customer);
    return new ResponseEntity<>(customerModel, HttpStatus.CREATED);
  }

  @DeleteMapping
  public ResponseEntity<String> deleteCustomer(Long id) {
    deleteCustomer.call(id);
    return new ResponseEntity<>("Customer deleted", HttpStatus.NO_CONTENT);
  }


}
