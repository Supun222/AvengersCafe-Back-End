package com.example.AvengersBack.Onboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired private CustomerRepository repo;

    public void save(customers customer){
        repo.save(customer);
    }

}
