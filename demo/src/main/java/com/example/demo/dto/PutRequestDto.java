package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

//해당클래스에 모든 Naming 룰을 적용시킬 수 있음.
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutRequestDto {
    private String name;
    private int age;

    private List<CarDto> carList;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<CarDto> getCarList() {
		return this.carList;
	}

	public void setCarList(List<CarDto> carList) {
		this.carList = carList;
	}


    @Override
    public String toString() {
        return name + age + carList.toString();
       
    }
}
