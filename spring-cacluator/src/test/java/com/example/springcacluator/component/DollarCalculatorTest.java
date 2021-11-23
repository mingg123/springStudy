package com.example.springcacluator.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
// @Import({ MarketApi.class, DollarCalcurator.class })
// SpringBootTest를 붙이는 순간 Import할 필요 없음
public class DollarCalculatorTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private DollarCalcurator dollarCalculator;

    @Test
    public void dollarCalculatorTest() {
        Mockito.when(marketApi.connect()).thenReturn(3000);
        dollarCalculator.init();
        int sum = dollarCalculator.sum(10, 10);
        System.out.println(sum);
        Assertions.assertEquals(60000, sum);
    }
}
