package com.example.AvengersBack.FoodOrder;


import com.example.AvengersBack.DTO.CashierDisplayOrder;
import com.example.AvengersBack.DTO.ConfirmFoodOrder;
import com.example.AvengersBack.DTO.SingleFoodOrder;
import com.example.AvengersBack.Food.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
public class FoodOrderController {

    @Autowired
    FoodOrderRepository repo;

    @PostMapping(path = "/order/newitem", consumes = {"application/json"})
    public String saveitem(@RequestBody FoodOrder newitem){
        repo.save(newitem);
        System.out.println("Data Saved");
        return "redirect:/Customer";
    }

    @DeleteMapping("/order/deleteitem/{foodorder_id}")
    public ResponseEntity<HttpEntity> deleteitem(@PathVariable("foodorder_id") int id){
        try{
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/order/cofirmorder")
    public ResponseEntity<List<ConfirmFoodOrder>> getconfirmorders(){

        try{
            List<Object[]> chefFoodItems = repo.retrivefoododers();
            List<ConfirmFoodOrder> chefOrders = new ArrayList<>();
            chefOrders = chefFoodItems.stream().map(objs->{
                ConfirmFoodOrder tempConfirMorders = new ConfirmFoodOrder();
                tempConfirMorders.setCus_id((Integer)objs[0]);
                tempConfirMorders.setTable_num((Integer)objs[1]);
                tempConfirMorders.setFname((String)objs[2]);
                tempConfirMorders.setPretime((Float) objs[3]);
                tempConfirMorders.setQuanity((Integer)objs[4]);
                return tempConfirMorders;
            }).collect(Collectors.toList());
            return new ResponseEntity<>(chefOrders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/order/checkorder")
    public ResponseEntity<List<CashierDisplayOrder>> getCheckOrders(){

        try{
            List<Object[]> checkItems = repo.retrivecheckFoodOrderList();
            List<CashierDisplayOrder> checkOrders = new ArrayList<>();
            checkOrders = checkItems.stream().map(obj->{
                CashierDisplayOrder tempcheckOrders = new CashierDisplayOrder();
                tempcheckOrders.setCusId((Integer)obj[0]);
                tempcheckOrders.setCName((String)obj[1]);
                tempcheckOrders.setTableNum((Integer) obj[2]);
                tempcheckOrders.setActType((String)obj[3]);
                tempcheckOrders.setTotalPrice((Float) obj[4]);
                return tempcheckOrders;
            }).collect(Collectors.toList());
            return new ResponseEntity<>(checkOrders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/order/singleorder/{cus_id}")
    public ResponseEntity<List<SingleFoodOrder>> getSignleOrders(@PathVariable("cus_id") Integer oid){

        try{
            List<Object[]> singleItem = repo.retriveSingleFoodOrderList(oid);
            List<SingleFoodOrder> singleOrders = new ArrayList<>();
            singleOrders = singleItem.stream().map(obj->{
                SingleFoodOrder tempsingleorder = new SingleFoodOrder();
                tempsingleorder.setOrderId((Integer)obj[0]);
                tempsingleorder.setQuantity((Integer) obj[1]);
                tempsingleorder.setFName((String) obj[2]);
                tempsingleorder.setPrice((Float)obj[3]);
                return tempsingleorder;
            }).collect(Collectors.toList());
            return new ResponseEntity<>(singleOrders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
