package com.example.AvengersBack.Onboard;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<customers, Integer> {


}
