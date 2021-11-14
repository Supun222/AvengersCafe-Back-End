package com.example.AvengersBack.CustomerOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerIDRepository extends JpaRepository<CustomerOrder,Integer> {

    @Query(value = "SELECT c.cusId, c.tableNum FROM CustomerOrder c WHERE c.actId=4")
    List<Object[]> findByActId();
}
