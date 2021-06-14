package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDto {
    
    private String name;

	@JsonProperty("car_number")
    private String carNumber;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarNumber() {
		return this.carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

    @Override
    public String toString() {
        return name +" " +  carNumber; 
    }
}
