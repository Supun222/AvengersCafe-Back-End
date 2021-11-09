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

    //@Autowired private CustomerService service;

    @Autowired
    CustomerRepository repo;

    // customers savedcus = (customers)this.repo.save(customer);
    // Assertions.assertThat(savedcus).isNotNull();
    // Assertions.assertThat(savedcus.getCus_id()).isGreaterThan(0);

    /*@RequestMapping("/index")
    public String onboard(){
        return "CustomerRegister.js";
    }*/

    /*
    @RequestMapping("/customer")
    public customers getcutomers(@RequestBody  customers newcus){

        service.save(newcus);

        return newcus;

        ///customers newcustomer = new customers();
        //newcustomer.setName(name);
        //newcustomer.setPhone("0772688805");
        //newcustomer.setTel("0112678882");
        //newcustomer.setNic("891011660");
        //newcustomer.setAddress("xxxx");
        ///customers savedcus = (customers)this.repo.save(newcustomer);
        //repo.save(savedcus);
        //customers savedcus = (customers)this.repo.save(newcustomer);
        //repo.save(savedcus);

    }


    /*@PostMapping("/save")
    public customers save(@RequestBody customers newcustomer){
        repo.save(newcustomer);
        return newcustomer;
    }


    @PostMapping ("/savecus")
    public customers addNewCustomers(@RequestBody customers newcustomer){
        repo.save(newcustomer);
        return newcustomer;
    }


    @PostMapping("/customer/save/{name}")
    public String saveUser(@PathVariable("name") String name){

        customers Customer = new customers();
        Customer.setName(name);
        Customer.setPhone("0772688805");
        Customer.setTel("0112678882");
        Customer.setNic("891011660");
        Customer.setAddress("xxxx");

        return "redirect:/Customer";
    }*/

}
