package com.example.AvengersBack.CustomerOrder;

import com.example.AvengersBack.DTO.ManagerDisplayOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerOrderController {

    @Autowired
    CustomerOrderRepository repo;

    @PostMapping(path = "/order/neworder", consumes = {"application/json"})
    public String saveorder(@RequestBody CustomerOrder neworder){
        repo.save(neworder);
        System.out.println("Data Saved");
        return "redirect:/Customer";
    }

    @PutMapping(path = "/order/cashierconfirm/{order_id}", consumes = {"application/json"})
    public ResponseEntity<CustomerOrder> cashierconfirm(@PathVariable("order_id") int id){
        Optional<CustomerOrder> updateorder = repo.findById(id);
        if(updateorder.isPresent()){
            CustomerOrder confirmorder = updateorder.get();
            confirmorder.setActId(3);
            return new ResponseEntity<>(repo.save(confirmorder), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/order/chefconfirm/{order_id}", consumes = {"application/json"})
    public ResponseEntity<CustomerOrder> chefconfirm(@PathVariable("order_id") int id){
        Optional<CustomerOrder> updateorder = repo.findById(id);
        if(updateorder.isPresent()){
            CustomerOrder confirmorder = updateorder.get();
            confirmorder.setActId(5);
            return new ResponseEntity<>(repo.save(confirmorder), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value = "/manager/dailyorders")
    public ResponseEntity<List<ManagerDisplayOrder>> getManagerDisplay(){
        try{
            List<Object[]> managerDisplayOrder = repo.retriveCustomerOders();
            List<ManagerDisplayOrder> managerorders = new ArrayList<>();
            managerorders = managerDisplayOrder.stream().map(obj->{
                ManagerDisplayOrder tempmanagerorders = new ManagerDisplayOrder();
                tempmanagerorders.setCusName((String)obj[0]);
                tempmanagerorders.setTableNum((Integer)obj[1]);
                tempmanagerorders.setActType((String)obj[2]);
                tempmanagerorders.setTotalPrice((Float)obj[3]);
                return tempmanagerorders;
            }).collect(Collectors.toList());
            return new ResponseEntity<>(managerorders, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
