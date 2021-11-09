package com.example.AvengersBack.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface FoodRepository extends JpaRepository<Food, Integer>{

    //@Query("select * from food where cat_id = ?1")
    List<Food> findBycatId(Integer cid);


   /*default List<Food> findByCategogyContaining(String name){
       return null;
   };*/
}
