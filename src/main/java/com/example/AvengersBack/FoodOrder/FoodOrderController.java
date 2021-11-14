package com.example.AvengersBack.FoodOrder;


import com.example.AvengersBack.CustomerOrder.CustomerID;
import com.example.AvengersBack.CustomerOrder.CustomerIDRepository;
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
@RequestMapping("/api")
public class FoodOrderController {

    @Autowired
    FoodOrderRepository repo;

    @Autowired
    CustomerIDRepository Crepo;

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
    public ResponseEntity<List<CustomerID>> getConfirmOrderCusId(){

        try{
            List<Object[]> cOrderCusId = Crepo.findByActId();
            List<CustomerID> confirmOrderCusId = new ArrayList<>();
            confirmOrderCusId = cOrderCusId.stream().map(obj->{
                CustomerID tempconfirmOrderCusId = new CustomerID();
                tempconfirmOrderCusId .setCusID((Integer)obj[0]);
                return tempconfirmOrderCusId;
            }).collect(Collectors.toList());
            return new ResponseEntity<>(confirmOrderCusId, HttpStatus.OK);
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
                tempsingleorder.setCusId((Integer)obj[1]);
                tempsingleorder.setQuantity((Integer) obj[2]);
                tempsingleorder.setFName((String) obj[3]);
                tempsingleorder.setPrice((Float)obj[4]);
                return tempsingleorder;
            }).collect(Collectors.toList());
            return new ResponseEntity<>(singleOrders, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
