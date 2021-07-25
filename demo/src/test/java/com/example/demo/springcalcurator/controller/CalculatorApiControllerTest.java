package com.example.demo.springcalcurator.controller;

import com.example.springcalcurator.component.Calculator;
import com.example.springcalcurator.component.DollarCalculator;
import com.example.springcalcurator.component.MarketApi;
import com.example.springcalcurator.controller.CalculatorApiController;
import com.example.springcalcurator.dto.CalculatorReq;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculatorApiController.class)
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class})
public class CalculatorApiControllerTest {
    
    @MockBean
    private MarketApi marketApi;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void sumTest() throws Exception {
        mockMvc.perform(
            MockMvcRequestBuilders.get("http://localhost:9090/api/calculator/sum")
            .queryParam("x", "10")
            .queryParam("y", "10")
        ).andExpect(
            MockMvcResultMatchers.status().isOk()
        ).andExpect(
            MockMvcResultMatchers.content().string("60000")
        ).andDo(
            MockMvcResultHandlers.print()
        );
    }


     @Test
    public void minusTest() throws Exception {
        CalculatorReq req = new CalculatorReq();
        req.setX(10);
        req.setY(10);

        String json = new ObjectMapper().writeValueAsString(req);
        mockMvc.perform(
            MockMvcRequestBuilders.post("http://localhost:9090/api/calculator/minus")
            .contentType(MediaType.APPLICATION_JSON)
            .contentType(json)
        ).andExpect(
            MockMvcResultMatchers.status().isOk()
        ).andDo(
            MockMvcResultHandlers.print()
        );
    }
}
