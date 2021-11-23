package com.example.cacluator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacluatorApplication {

	public static void main(String[] args) {

		// SpringApplication.run(CacluatorApplication.class, args);
		// Calculator calculator = new Calculator(new KrwCalcurator());
		MarketApi marketApi = new MarketApi();
		DollarCalcurator dollarCalcurator = new DollarCalcurator(marketApi);
		dollarCalcurator.init();

		Calculator calculator = new Calculator(dollarCalcurator);
		System.out.println(calculator.sum(10, 10));
	}

}
