package com.example.AvengersBack.DTO;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmFoodOrder implements Serializable {

    private Integer cus_id;
    private String fname;
    private Integer quanity;
    private Float pretime;

}
