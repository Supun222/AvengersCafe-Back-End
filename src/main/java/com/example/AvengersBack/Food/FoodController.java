package com.example.AvengersBack.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class FoodController {

    @Autowired
    FoodRepository repo;

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
            List<Food> category = repo.findBycatId(cid);

            if(category.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(category, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}


