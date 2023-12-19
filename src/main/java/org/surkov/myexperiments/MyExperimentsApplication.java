package org.surkov.myexperiments;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.surkov.myexperiments.Entity.Customer;

import java.util.*;

@SpringBootApplication
public class MyExperimentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyExperimentsApplication.class, args);
	}
}
