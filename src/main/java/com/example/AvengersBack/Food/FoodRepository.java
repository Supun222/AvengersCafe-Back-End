package com.example.AvengersBack.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface FoodRepository extends JpaRepository<Food, Integer>{

    @Query("select f from Food f where f.catId =:cid")
    List<Food> findByCatId(int cid);

    //@Query(value = "SELECT * FROM `food` WHERE cat_id=?1" , nativeQuery = true)
    //List<Object[]> retriveCategoryFood(Integer catId);
   /*default List<Food> findByCategogyContaining(String name){
       return null;
   };*/
}
