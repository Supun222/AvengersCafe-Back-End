package com.example.AvengersBack.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDisplayOrder {

    private String cusName;
    private Integer tableNum;
    private String actType;
    private Float totalPrice;


}
