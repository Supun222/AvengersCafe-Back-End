package com.example.AvengersBack.CustomerOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

    @Query(value = "SELECT customer.name , customerorder.table_num, activity_type.act_type, customerorder.total_price FROM customerorder, customer, activity_type " +
            "WHERE customerorder.cus_id=customer.cus_id AND customerorder.act_id=activity_type.act_id ", nativeQuery = true)
    List<Object[]> retriveCustomerOders();

    @Query("SELECT o FROM CustomerOrder o WHERE o.cusId=:id")
    public Optional<CustomerOrder> findByCusId(int id);
    //SELECT COUNT(order_id) AS completed FROM `customerorder` WHERE act_id=5 - completed orders
    //SELECT COUNT(order_id) AS pending FROM `customerorder` WHERE act_id=4
    //SELECT COUNT(order_id) AS totalorders FROM `customerorder`


}
