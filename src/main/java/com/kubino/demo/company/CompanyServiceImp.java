package com.kubino.demo.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImp implements CompanyService{

    private final CompanyRepository repository;

    public CompanyServiceImp(@Autowired CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public int saveCompany(Company company) {
        repository.save(company);
        return company.getId();
    }

    @Override
    public Optional<Company> findById(int id) {
        return repository.findById(id);
    }
}
