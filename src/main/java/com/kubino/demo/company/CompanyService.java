package com.kubino.demo.company;

import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CompanyService {
    int saveCompany(Company company);
    Optional<Company> findById(int id);
}
