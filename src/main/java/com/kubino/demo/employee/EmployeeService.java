package com.kubino.demo.employee;

import java.util.Optional;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    Optional<Employee> findById(int id);
}
