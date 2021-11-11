package com.example.AvengersBack.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CashierDisplayOrder {

    private Integer cusId;
    private String cName;
    private Integer tableNum;
    private String actType;
    private Float totalPrice;

}
