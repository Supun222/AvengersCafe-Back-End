package com.example.AvengersBack.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SingleFoodOrder {

    private Integer orderId;
    private Integer cusId;
    private Integer quantity;
    private String fName;
    private Float price;
}
