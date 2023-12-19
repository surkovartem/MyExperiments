package org.surkov.myexperiments.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
@Entity
@Table(name = "customers_info")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = Fields.firstName)
  private String firstName;
  @Column(name = Fields.secondName)
  private String secondName;

  public Customer(Long id, String firstName, String secondName) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
  }

  public Customer() {

  }
}
