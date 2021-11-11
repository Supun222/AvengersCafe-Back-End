package com.example.AvengersBack.CustomerOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

    @Query(value = "SELECT customer.name , customerorder.table_num, activity_type.act_type, customerorder.total_price FROM customerorder, customer, activity_type " +
            "WHERE customerorder.cus_id=customer.cus_id AND customerorder.act_id=activity_type.act_id ", nativeQuery = true)
    List<Object[]> retriveCustomerOders();
}
