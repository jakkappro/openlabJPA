package com.kubino.demo.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImp implements AddressService {

    private final AddressRepository repository;

    public AddressServiceImp(@Autowired AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public int saveAddress(Address address) {
        repository.save(address);
        return 0;
    }
}
