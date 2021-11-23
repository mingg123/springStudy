package com.example.springcacluator.component;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DollarCalcurator implements ICalculator {

    private int price = 1;
    private final MarketApi marketApi;

    // public DollarCalcurator(MarketApi marketApi) {
    // this.marketApi = marketApi;
    // }

    @Override
    public void init() {
        this.price = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y;

    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x - y;
    }

}
