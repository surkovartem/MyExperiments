package org.surkov.myexperiments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.surkov.myexperiments.entity.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

  Optional<Customer> findCustomerById(Long id);
}
