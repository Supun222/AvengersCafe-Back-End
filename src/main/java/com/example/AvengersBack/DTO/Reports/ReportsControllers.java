package com.example.AvengersBack.DTO.Reports;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ReportsControllers {
    
    @Autowired
    ReportsRepository repo;
    
    @GetMapping(value = "order/reports/{type}")
    public ResponseEntity<Integer> getTotalRevenue(@PathVariable("type") String type){
        Integer orderTypeCount;
        switch(type){

            case "billed" :
                orderTypeCount = repo.getRevenue(3);
            break;

            case "pending" :
                orderTypeCount = repo.getRevenue(4);
            break;

            default:
                orderTypeCount = repo.getRevenue(5);
        }


        
        return new ResponseEntity<>(orderTypeCount, HttpStatus.OK);
    }
}
