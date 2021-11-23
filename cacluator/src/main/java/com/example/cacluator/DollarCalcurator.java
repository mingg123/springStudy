package com.example.cacluator;

public class DollarCalcurator implements ICalculator {

    private int price = 1;
    private MarketApi marketApi;

    public DollarCalcurator(MarketApi marketApi) {
        this.marketApi = marketApi;
    }

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
