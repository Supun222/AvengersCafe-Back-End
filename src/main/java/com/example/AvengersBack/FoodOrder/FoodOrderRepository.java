package com.example.AvengersBack.FoodOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodOrderRepository extends JpaRepository<FoodOrder,Integer> {

    @Query(value = "SELECT customerorder.order_id, foodorder.cus_id, food.name, food.preptime, foodorder.quantity  FROM food, foodorder, customerorder" +
            "            WHERE foodorder.cus_id=2  AND foodorder.food_id=food.food_id AND customerorder.cus_id=foodorder.cus_id", nativeQuery = true)
    List<Object[]> retrivefoododers(Integer cus_id);



    @Query(value = "SELECT customer.cus_id, customer.name , customerorder.table_num, activity_type.act_type, customerorder.total_price FROM customerorder, " +
            "customer, activity_type " +
            "WHERE customerorder.cus_id=customer.cus_id AND customerorder.act_id=activity_type.act_id", nativeQuery = true)
    List<Object[]> retrivecheckFoodOrderList();

    @Query(value = "SELECT customerorder.order_id, customerorder.cus_id, foodorder.quantity, food.name, food.price FROM customerorder, food, foodorder " +
            " WHERE customerorder.cus_id=?1 AND customerorder.cus_id=foodorder.cus_id AND food.food_id=foodorder.food_id", nativeQuery = true)
    List<Object[]> retriveSingleFoodOrderList(Integer cus_id);

    //@Query(value = "SELECT site_visit_schedule.*, user.first_name, user.last_name FROM ((site_visit_schedule inner JOIN site_visit_schedule_resources ON site_visit_schedule.id = site_visit_schedule_resources.site_visit_schedule_id)INNER JOIN user ON user.id = site_visit_schedule_resources.user_id) WHERE site_visit_schedule.valuation_req_id=?1 order by site_visit_schedule.id", nativeQuery = true)
    //List<Object[]> siteVisitFindByValuationRequestID(Long id)
}
