package com.example.AvengersBack.DTO.Reports;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reports {

    private int totalOrders;
    private int totalPendings;
    private int totalCompleted;
    private int revenue;

}
