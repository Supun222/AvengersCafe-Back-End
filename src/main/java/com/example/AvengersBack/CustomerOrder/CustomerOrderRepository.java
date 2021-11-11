package com.example.AvengersBack.CustomerOrder;

import com.example.AvengersBack.DTO.Reports.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

    @Query(value = "SELECT customer.name , customerorder.table_num, activity_type.act_type, customerorder.total_price FROM customerorder, customer, activity_type " +
            "WHERE customerorder.cus_id=customer.cus_id AND customerorder.act_id=activity_type.act_id ", nativeQuery = true)
    List<Object[]> retriveCustomerOders();

    //SELECT COUNT(order_id) AS completed FROM `customerorder` WHERE act_id=5 - completed orders
    //SELECT COUNT(order_id) AS pending FROM `customerorder` WHERE act_id=4
    //SELECT COUNT(order_id) AS totalorders FROM `customerorder`

    //List<Reports> findByTotalOrders(int act_id);
}
