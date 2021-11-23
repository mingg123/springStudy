package com.example.springcacluator.component;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor // 생성자 없어도됨 이거 사용하면
public class Calculator {

    private final ICalculator iCalculator;

    // public Calculator(ICalculator iCalculator) {
    // this.iCalculator = iCalculator;
    // }

    public int sum(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.sum(x, y);
    }

    public int minus(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.minus(x, y);
    }
}
