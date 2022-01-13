package com.kubino.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImp(@Autowired EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return repository.findById(id);
    }
}
