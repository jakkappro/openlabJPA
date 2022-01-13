package com.kubino.demo.company;

import com.kubino.demo.address.Address;
import com.kubino.demo.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String name;

    @OneToOne(cascade = {CascadeType.REMOVE})
    @Valid
    private Address address;

    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;
}
