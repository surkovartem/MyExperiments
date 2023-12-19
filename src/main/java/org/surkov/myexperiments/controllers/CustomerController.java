package org.surkov.myexperiments.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.surkov.myexperiments.entity.Customer;
import org.surkov.myexperiments.controllers.interfaces.CustomerСontrollerOperation;
import org.surkov.myexperiments.repository.CustomerRepository;
import org.surkov.myexperiments.services.CustomerService;
import org.surkov.myexperiments.utils.CustomResponse;


@Slf4j
@RestController
public class CustomerController implements CustomerСontrollerOperation {

  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  CustomerService customerService;

  @Override
  public CustomResponse<Customer> getAllCustomers() {
    log.info("Получение списка customers.");
    return customerService.getAllCustomers();
  }

  @Override
  public CustomResponse<Customer> getCustomerById(@PathVariable("id") long id) {
    log.info("Получение customer по id = " + id);
    return customerService.getCustomerById(id);
  }

  @Override
  public CustomResponse<Customer> addCustomer(Customer customer) {
    log.info("Добавление нового customer");
    return customerService.addCustomer(customer);
  }

  @Override
  public CustomResponse<Customer> putCustomer(@PathVariable("id") Long id, Customer customer) {
    log.info("Обновление customer c id = " + id);
    return customerService.putCustomer(id, customer);
  }

  @Override
  public CustomResponse<Customer> deleteCustomerById(@PathVariable("id") long id) {
    log.info("Удаление customer c id = " + id);
    return customerService.deleteCustomerById(id);
  }

  @Override
  public CustomResponse<Customer> deleteAllCustomers() {
    log.info("Удаление всех customers.");
    return customerService.deleteAllCustomers();
  }
}