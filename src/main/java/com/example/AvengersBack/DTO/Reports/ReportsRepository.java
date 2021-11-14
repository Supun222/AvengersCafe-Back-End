package com.example.AvengersBack.DTO.Reports;

import com.example.AvengersBack.CustomerOrder.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportsRepository extends JpaRepository<CustomerOrder, Integer> {

    @Query(value = "SELECT COUNT(order_id) AS totalorder FROM `customerorder` WHERE act_id=?1" , nativeQuery = true)
    public Integer getRevenue(Integer actId);

    @Query("SELECT SUM(c.totalPrice) FROM CustomerOrder c WHERE c.actId=4 OR c.actId=3")
    public Float sumByTotalPrice();
    //List<Reports> findByTotalOrders(int act_id);
}
