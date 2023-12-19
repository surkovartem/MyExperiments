package org.surkov.myexperiments.controllers.interfaces;

import org.springframework.web.bind.annotation.*;
import org.surkov.myexperiments.entity.Customer;
import org.surkov.myexperiments.utils.CustomResponse;

@RequestMapping("/api")
public interface CustomerСontrollerOperation {

  @GetMapping("/customers")
  CustomResponse<Customer> getAllCustomers();

  @GetMapping("/customers/{id}")
  CustomResponse<Customer> getCustomerById(@PathVariable("id") long id);

  @RequestMapping(value = "/customer", method = RequestMethod.POST)
  CustomResponse<Customer> addCustomer(Customer customer);

  @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
  CustomResponse<Customer> putCustomer(@PathVariable("id") Long id, Customer customer);

  @DeleteMapping("/customer/{id}")
  CustomResponse<Customer> deleteCustomerById(@PathVariable("id") long id);

  @DeleteMapping("/customers")
  CustomResponse<Customer> deleteAllCustomers();
}
