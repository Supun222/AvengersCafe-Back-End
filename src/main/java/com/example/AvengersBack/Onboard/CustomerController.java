package com.example.AvengersBack.Onboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://thirsty-nobel-63e08c.netlify.app", allowedHeaders = "")
@RequestMapping("/customer/save")
public class CustomerController {

    @Autowired
    CustomerRepository repo;

    @PostMapping(path = "/", consumes = {"application/json"})
    public int saveUser(@RequestBody customers newcus) {
        repo.save(newcus);
        return newcus.getCus_id();
    }
}
