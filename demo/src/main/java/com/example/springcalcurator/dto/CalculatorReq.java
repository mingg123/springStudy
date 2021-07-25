package com.example.springcalcurator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorReq {
    private int x;
    private int y;
}
