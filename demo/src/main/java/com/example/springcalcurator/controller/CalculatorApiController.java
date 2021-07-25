package com.example.springcalcurator.controller;





import com.example.springcalcurator.component.Calculator;
import com.example.springcalcurator.dto.CalculatorReq;
import com.example.springcalcurator.dto.CalculatorRes;
import com.example.springcalcurator.dto.CalculatorRes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
public class CalculatorApiController {
    
    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y) {
        return calculator.sum(x, y);
    }

    @PostMapping("/minus")
    public CalculatorRes minus(@RequestBody CalculatorReq req) {
        int result = calculator.minus(req.getX(), req.getY());

        CalculatorRes res = new CalculatorRes();
        res.setResult(result);
        return res;
        
    }

   
}
