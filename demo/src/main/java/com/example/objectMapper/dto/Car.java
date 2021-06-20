package com.example.objectMapper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String name;

    @JsonProperty("car_number")
    private String carNumber;

    @JsonProperty("TYPE")
    private String type;


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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

    @Override
    public String toString() {
        return name + " " + carNumber + " " + type;
    }
}