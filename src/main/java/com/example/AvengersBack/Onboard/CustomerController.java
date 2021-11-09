package com.example.AvengersBack.Onboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repo;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/customer/save", consumes = {"application/json"})
    public String saveUser(@RequestBody customers newcus){
        repo.save(newcus);
        return "redirect:/Customer";
    }

}
