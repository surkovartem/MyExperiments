package org.surkov.myexperiments.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.surkov.myexperiments.entity.Customer;
import org.surkov.myexperiments.repository.CustomerRepository;
import org.surkov.myexperiments.utils.CustomResponse;
import org.surkov.myexperiments.utils.CustomStatus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  public CustomResponse<Customer> getAllCustomers() {
    List<Customer> customers = customerRepository.findAll();
    return new CustomResponse<>(customers, CustomStatus.SUCCESS);
  }

  public CustomResponse<Customer> getCustomerById(long id) {
    Customer customer = customerRepository.findCustomerById(id).orElseThrow();
    return new CustomResponse<>(Stream.of(customer).collect(Collectors.toList()), CustomStatus.SUCCESS);
  }

  public CustomResponse<Customer> addCustomer(Customer customer) {
    Customer newCustomer =
        customerRepository.save(new Customer(customer.getId(), customer.getFirstName(), customer.getSecondName()));
    return new CustomResponse<>(Stream.of(newCustomer).collect(Collectors.toList()), CustomStatus.SUCCESS);
  }

  public CustomResponse<Customer> putCustomer(Long id, Customer customer) {
    Customer customerToUpdate = customerRepository.findById(id).orElseThrow();
    customerToUpdate.setId(id);
    customerToUpdate.setFirstName(customer.getFirstName());
    customerToUpdate.setSecondName(customer.getSecondName());
    customerRepository.save(customerToUpdate);
    return new CustomResponse<>(Stream.of(customerToUpdate).collect(Collectors.toList()), CustomStatus.SUCCESS);
  }

  public CustomResponse<Customer> deleteCustomerById(long id) {
    customerRepository.deleteById(id);
    return new CustomResponse<>(null, CustomStatus.SUCCESS);
  }

  public CustomResponse<Customer> deleteAllCustomers() {
    customerRepository.deleteAll();
    return new CustomResponse<>(null, CustomStatus.SUCCESS);
  }
}
