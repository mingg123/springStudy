package com.example.springcalcurator.component;

import org.springframework.stereotype.Component;


public interface ICalculator {
    int sum(int x, int y);
    int minus(int x, int y);
    void init();
}
