package com.example.demo.springcalcurator.component;

import com.example.springcalcurator.component.DollarCalculator;
import com.example.springcalcurator.component.MarketApi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({MarketApi.class, DollarCalculator.class})

public class CalculatorApplicationTests {
    

    @MockBean
    private MarketApi marketApi;


    @Autowired
    private DollarCalculator dollarCalculator;

    @Test
    public void dollarCalculatorTest() {
      
        Mockito.when(marketApi.connect()).thenReturn(3000);
        dollarCalculator.init();
        int sum = dollarCalculator.sum(10, 10);
        int minus = dollarCalculator.minus(10, 10);

        Assertions.assertEquals(60000, sum);
        Assertions.assertEquals(0, minus);
    }
}
