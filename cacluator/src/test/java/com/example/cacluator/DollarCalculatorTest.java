package com.example.cacluator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DollarCalculatorTest {

    // Mock처리를 해서 값을 미리 넣어볼 경우에
    @Mock
    public MarketApi marketApi;

    @BeforeEach
    public void init() {
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void testHello() {
        System.out.println("hello");
    }

    @Test
    public void dollarTest() {
        MarketApi marketApi = new MarketApi();
        DollarCalcurator dollarCalcurator = new DollarCalcurator(marketApi);
        dollarCalcurator.init();

        Calculator calculator = new Calculator(dollarCalcurator);
        System.out.println(calculator.sum(10, 10));
        Assertions.assertEquals(22000, calculator.sum(10, 10));
        Assertions.assertEquals(-10, calculator.minus(0, 10));
    }

    @Test
    public void mockTest() {
        DollarCalcurator dollarCalcurator = new DollarCalcurator(marketApi);
        dollarCalcurator.init();

        Calculator calculator = new Calculator(dollarCalcurator);
        System.out.println(calculator.sum(10, 10));
        Assertions.assertEquals(60000, calculator.sum(10, 10));
        Assertions.assertEquals(0, calculator.minus(10, 10));
    }

}
