package com.example.AvengersBack.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer> {


}
