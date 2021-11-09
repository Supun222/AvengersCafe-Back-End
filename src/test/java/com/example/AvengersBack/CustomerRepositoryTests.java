package com.example.AvengersBack;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.AvengersBack.Onboard.CustomerRepository;
import com.example.AvengersBack.Onboard.customers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {
    @Autowired private CustomerRepository repo;

    @Test
    public void testAddnew(){
        customers customer = new customers();
        customer.setName("Supun");
        customer.setNic("981011660V");
        customer.setDate("2021-11-01");
        customer.setPhone("0772688805");
        customer.setAddress("xxxx");
        
        customers savedcus = repo.save(customer);

        assertThat(savedcus).isNotNull();
        assertThat(savedcus.getCus_id()).isGreaterThan(0);

    }

    @Test
    public void testListAll(){
        Iterable<customers> cusall = repo.findAll();
        assertThat(cusall).hasSizeGreaterThan(0);
        for(customers cus : cusall){
            System.out.println(cus);
        }
    }
}
