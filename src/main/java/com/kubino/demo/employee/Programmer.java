package com.kubino.demo.employee;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Programmer extends Employee{
}
