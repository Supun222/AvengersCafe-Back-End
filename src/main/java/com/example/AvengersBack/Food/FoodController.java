package com.example.AvengersBack.Food;

import com.example.AvengersBack.DTO.SingleFoodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost/build/#")
@RestController
@RequestMapping("/api")
public class FoodController {

    @Autowired
    FoodRepository repo;

    @Autowired
    FoodCategoryRepository Crepo;

    @GetMapping("/customer/save/FoodMenu")
    @ResponseBody
    public List<Food> getfoods(){
        return repo.findAll();
    }

    @RequestMapping(path = "/customer/save/FoodMenu/{food_id}")
    @ResponseBody
    public Optional<Food> getFood(@PathVariable("food_id") int fid){
        return repo.findById((fid));
    }

    @GetMapping(path = "/customer/save/FoodMenu/FoodCategory/{cat_id}"  )
    public ResponseEntity<List<Food>> getFoodcategory(@PathVariable("cat_id") Integer cid){

        try{
            List<Food> category = repo.findByCatId(cid);

            if(category.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(category, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/foodmenu/{cat_id}")
    public ResponseEntity<List<Food>> getFoodCategory(@PathVariable("cat_id") Integer cid){

        List<Food> categoryFood = repo.findByCatId(cid);
        return new ResponseEntity<>(categoryFood, HttpStatus.OK);
        /*
        try{
            List<Object[]> foodList = repo.retriveCategoryFood(cid);
            List<Food> catFood = new ArrayList<>();
            catFood = foodList.stream().map(obj->{
                Food tempCatFood = new Food();
                tempCatFood.setFood_id((Integer)obj[0]);
                tempCatFood.setCat_id((Integer) obj[1]);
                tempCatFood.setName((String) obj[2]);
                tempCatFood.setImage((String) obj[4]);
                tempCatFood.setPreptime((Float)obj[5]);
                tempCatFood.setPrice((Float)obj[6]);
                return tempCatFood;
            }).collect(Collectors.toList());
            return new ResponseEntity<>(catFood, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }

}


