package com.example.AvengersBack.CustomerOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerID {
    private Integer cusID;
    private Integer tableNum;
}
