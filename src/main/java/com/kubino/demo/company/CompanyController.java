package com.kubino.demo.company;

import com.kubino.demo.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CompanyController {

    private final CompanyService companyService;
    private final AddressService addressService;

    public CompanyController(@Autowired CompanyService companyService, @Autowired AddressService addressService) {
        this.companyService = companyService;
        this.addressService = addressService;
    }

    //Tetno ednpoint nefunguje bol v prvom cviceni ale teraz treba adresu aby fungoval
    @GetMapping("/company")
    public void getCompany() {
        companyService.saveCompany(new Company());
    }

    @PostMapping("/company/new")
    public void createCompany(@Valid @RequestBody Company company) {
        addressService.saveAddress(company.getAddress());
        companyService.saveCompany(company);
    }

    @GetMapping("/company/get/{id}")
    public Company getCompany(@PathVariable int id) {
        return companyService.findById(id).isPresent() ? companyService.findById(id).get() : null;
    }
}
